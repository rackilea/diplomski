public void paint( Graphics gx ) {
    Graphics2D g = (Graphics2D) gx;

    AffineTransform scale = AffineTransform.getScaleInstance(
           xPixels/numberOfSteps*stepWidth, 
           yPixels/numberOfSteps*stepHeigth );
    g.transform(scale);
    for( int i = 0; i < numberOfSteps; ++ i ) {
        step( g );
    }
 }