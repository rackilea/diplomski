static final long MINIMUM_DELAY = 1000/30; // So we can have 30 shots per second
long lastShotTimestamp;

protected void shoot(int x, int y, double dir) {
    long now = System.currentTimeMillis();

    if (now - lastShotTimestamp > MINIMUM_DELAY) {
        level.addProjectile(new Bomb(x, y, dir));
        lastShotTimestamp = now;
    }
}