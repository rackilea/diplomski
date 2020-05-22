Bullet(float x, float y, float radians) {
    this.x = x;
    this.y = y;
    this.radians = radians;

    float speed = 350;
    dx = speed * MathUtils.cos(radians) + Player.getPlayerDeltaX();
    dy = speed * MathUtils.sin(radians) + Player.getPlayerDeltaY();

    width = height = 2;

    lifeTimer = 0;
    lifeTime = 1;
}