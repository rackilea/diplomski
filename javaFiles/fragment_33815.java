batch.begin();

// first disable batch blending changes (see javadoc)
batch.setBlendFunction(-1, -1);

// then use special blending.
Gdx.gl.glBlendFuncSeparate(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA,GL20.GL_SRC_ALPHA, GL20.GL_DST_ALPHA);

... your drawings ...

batch.end();