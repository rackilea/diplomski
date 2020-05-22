@Override public void render(float deltaTime) {
        update(delta);
        spriteBatch.setProjectionMatrix(cam.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, cam.position.x - (WIDTH / 2), 0, WIDTH, HEIGHT);
....
   spriteBatch.end();}