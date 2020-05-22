public void render(float delta){
    ...
    beam.update(delta);

    spriteBatch.begin();
    beam.draw(spritebatch);
    spriteBatch.end();
}