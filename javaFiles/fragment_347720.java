@Override
public void render( float delta )
{
    /*Wipe Screen to black*/
    Gdx.gl.glClearColor( Color.BLACK );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );

    /*Left Half*/
    Gdx.gl.glViewport( 0,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight() );
    //Set up camera with viewport in mind
    draw( delta );

    /*Right Half*/
    Gdx.gl.glViewport( Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight() );
    //Set up camera again with other viewport in mind
    draw( delta );
}