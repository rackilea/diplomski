private ShapeRenderer renderer;
private SequenceAction action;

@Override
public void create() {

    Vector2 center = new Vector2( 0.5f * Gdx.graphics.getWidth(), 0.5f * Gdx.graphics.getHeight() );

    renderer = new ShapeRenderer();
    action = Actions.sequence(
            new LineAction( 0.5f, new Vector2( 0, 0 ).add( center ), new Vector2( -20, 40 ).add( center ), 1, renderer ),
            new LineAction( 0.5f, new Vector2( -20, 40 ).add( center ), new Vector2( -40, 0 ).add( center ), 1, renderer ),
            new LineAction( 0.5f, new Vector2( -40, 0 ).add( center ), new Vector2( 20, 0 ).add( center ), 1, renderer ),
            new CirleAction( 0.5f, center, 30, 20, 0, -315, 1, renderer )
    );
    action.setActor( new Actor() );
}

@Override
public void render() {

    Gdx.gl.glClearColor( 0, 0, 0, 1 );
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

    renderer.begin( ShapeRenderer.ShapeType.Line );
    action.act( Gdx.graphics.getDeltaTime() );
    renderer.end();
}