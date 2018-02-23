package jp.techacademy.yxx3tch.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by yxx3tch on 2018/02/22.
 */

public class Enemy extends GameObject {

    // 横幅、高さ
    public static final float ENEMY_WIDTH = 0.8f;
    public static final float ENEMY_HEIGHT = 0.8f;

    // 速度
    public static final float ENEMY_VELOCITY = 1.0f;

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        velocity.x = ENEMY_VELOCITY;
    }

    // 座標を更新する
    public void update(float deltaTime) {
        setX(getX() + velocity.x * deltaTime);

        if (getX() < ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(ENEMY_WIDTH / 2);
        }
        if (getX() > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2);
        }
    }

    public void bomb(Texture texture) {
        this.setTexture(texture);
    }

}
