@Override
public void render () {
    time = time + Gdx.graphics.getDeltaTime();
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    renderer.setView(orthographicCamera);
    renderer.render();

    batch.setProjectionMatrix(orthographicCamera.combined);
    batch.begin();
    batch.draw((TextureRegion)animation.getKeyFrame(time,true),orthographicCamera.position.x-spriteCorridore.getWidth()/2,orthographicCamera.position.y-spriteCorridore.getHeight()/2);
    batch.end();

    orthographicCamera.translate(1, 0);
    orthographicCamera.update();   
}