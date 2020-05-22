private static Area createShape ()
{
    Area shape = new Area ( new RoundRectangle2D.Double ( 0, 20, 500, 200, 20, 20 ) );

    GeneralPath gp = new GeneralPath ( GeneralPath.WIND_EVEN_ODD );
    gp.moveTo ( 230, 20 );
    gp.lineTo ( 250, 0 );
    gp.lineTo ( 270, 20 );
    gp.closePath ();
    shape.add ( new Area ( gp ) );

    return shape;
}