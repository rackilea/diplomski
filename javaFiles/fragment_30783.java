@Override
    public void render(float delta) {
        Gdx.graphics.getGLCommon().glClearColor( 1, 0, 0, 1 );
        Gdx.graphics.getGLCommon().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        score();
        btch.begin();
        fntscore.draw(btch, "score: " + currscore, 100, 100);
        btch.end();
        // TODO Auto-generated method stub

    }