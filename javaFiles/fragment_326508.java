ArrayList<Sprite> dozenSprites; // these are all the sprites of one SpriteBatch in a list
SpriteBatch spriteBatch = new SpriteBatch(spriteBatchTextureAtlas, dozenSprites.size(),vertexBufferObjectManager);

for (Sprite sprite : dozenSprites) {
        sprite.setColor(.5f, .5f, .5f);
        spriteBatch.draw(sprite);
}
spriteBatch.submit();