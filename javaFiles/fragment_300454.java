public void render() {
    GLCommon gl = Gdx.gl;

    camera.update();
    camera.apply(Gdx.gl10);
    //this is no longer needed:
    //spriteBatch.setProjectionMatrix(camera.combined);
    //...