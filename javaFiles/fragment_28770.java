@Override
public void render() {  
    super.render();

    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

     camera.update();
     batch.setProjectionMatrix(camera.combined);

     batch.begin();
     batch.draw(backgroundTexture, 0, 0); 
     batch.end();