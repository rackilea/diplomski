class LineAction extends TemporalAction {

    private Vector2 pointA = new Vector2(), pointB = new Vector2(), tmp = new Vector2();
    private float lineWidth;
    private ShapeRenderer renderer;

    public LineAction( float duration, Vector2 pointA, Vector2 pointB, float lineWidth, ShapeRenderer renderer ){

        super( duration );

        this.pointA.set( pointA );
        this.pointB.set( pointB );
        this.lineWidth = lineWidth;
        this.renderer = renderer;
        this.actor = new Actor();
    }

    @Override
    protected void update( float percent ) {

        Vector2 point = tmp
                .set( pointB )
                .sub( pointA )
                .scl( percent )
                .add( pointA );

        renderer.rectLine( pointA, point, lineWidth );
    }
}