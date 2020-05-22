Gdx.gl.glEnable(GL10.GL_BLEND);
Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
shapeRenderer.setProjectionMatrix(camera.combined);
shapeRenderer.begin(ShapeType.FilledCircle);
shapeRenderer.setColor(new Color(0, 1, 0, 0.5f));
shapeRenderer.filledCircle(470, 45, 10);
shapeRenderer.end();
Gdx.gl.glDisable(GL10.GL_BLEND);