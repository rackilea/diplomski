public void update(float delta) {
    if (pos.x > Kiwi.WIDTH / 2)
        vel.add(-5, 0, 0);
    vel.x *= 0.8f;
    vel.scl(delta);
    pos.add(vel.x, 0, 0);
    vel.scl(1 / delta);
}