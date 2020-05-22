@Override
public void render() {

    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    polyBatch.begin();
    polySprite.draw(polyBatch);
    polyBatch.end();

}