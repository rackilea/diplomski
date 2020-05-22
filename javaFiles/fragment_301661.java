public void render(SpriteBatch spriteBatch) {
    spriteBatch.setProjectionMatrix(camera.combined); // Let the Sprite Batch use the camera
    spriteBatch.begin();
    // [Draw your Textures, TextureRegions, Sprites, etc...]
    spriteBatch.end();
}