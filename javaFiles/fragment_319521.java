public void update(World world, float delta) {
    frameTimer += delta;

    if( frameTimer >= rate / 1000) {
        fireAtEnemy(world);
        frameTimer = 0;
    }
}