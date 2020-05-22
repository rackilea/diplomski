public void render(float delta){
    ...
    beam.update(delta);

    spriteBatch.begin();
    spriteBatch.draw(beam.getTexture(), beam.getBound().x, beam.getBound().y);
    spriteBatch.end();

}