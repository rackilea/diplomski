class CircleAction extends TemporalAction {

    private Vector2[] points;
    private float lineWidth;
    private ShapeRenderer renderer;

    public CirleAction( float duration, Vector2 offset, int length, float radius, float startAngle, float endAngle, float lineWidth, ShapeRenderer renderer ){

        super( duration );

        this.points = new Vector2[ length ];
        this.lineWidth = lineWidth;
        this.renderer = renderer;
        this.actor = new Actor();

        float degrees = (endAngle - startAngle) / (float) length;

        for ( int i = 0; i < length; ++i ){
            points[ i ] = new Vector2( radius, 0 ).rotate( degrees * i ).add( offset );
        }
    }

    @Override
    protected void update( float percent ) {

        for ( int i = 0, l = MathUtils.floor( (points.length - 1) * percent ); i < l; ++i ) {
            renderer.rectLine( points[ i ], points[ i + 1 ], lineWidth );
        }
    }
}