@Override
public void render () {
    Gdx.gl.glClearColor(1, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    stage.draw();  //<--  Call draw method of stage inside render, it calls draw on every actor in the stage 
    stage.act();
}