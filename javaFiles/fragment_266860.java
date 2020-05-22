public void update(float deltaTime) {
            if (deltaTime <= 0) {
                deltaTime=.001f;
            }
        velocity.scl(deltaTime);
        position.add(MOVEMENT * deltaTime, velocity.y);
...
}