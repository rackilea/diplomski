@Override
public void render(float delta) {
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
stage.act();
stage.draw();

}