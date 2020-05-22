Bullet(float x, float y, float playerDeltaX, float playerDeltaY, float radians) {
    this.x = x;
    this.y = y;
    this.radians = radians;

    float speed = 350;
    dx = speed * MathUtils.cos(radians) + playerDeltaX;
    dy = speed * MathUtils.sin(radians) + playerDeltaY;

    width = height = 2;

    lifeTimer = 0;
    lifeTime = 1;

}