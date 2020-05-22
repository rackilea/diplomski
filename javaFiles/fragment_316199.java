@Override
public void render(){
    super.render(); //<-----

    Gdx.gl.glClearColor(1,  1,  1,  1);
    Gdx.gl.glClear(Gdx.gl10.GL_COLOR_BUFFER_BIT);
    cam.update();
    batch.setProjectionMatrix(cam.combined);

    batch.begin();
    player.draw(batch);
    input();
    update();
    batch.end();
}