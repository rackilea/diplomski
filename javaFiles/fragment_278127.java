@Override
public void render () {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    camera.unproject(tp.set(Gdx.input.getX(), Gdx.input.getY(), 0));
    font.draw(batch,tp.x+ " , " + tp.y, tp.x - 25, tp.y - 5);
    batch.draw(img, tp.x, tp.y);
    batch.end();
}