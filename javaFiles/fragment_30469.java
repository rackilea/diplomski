@Override
   public void render(float delta) {
     Gdx.gl.glClearColor(1, 0, 0, 1);
     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
     stage.act();
     stage.draw();
}