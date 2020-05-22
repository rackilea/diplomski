double xScale = 100/image.getWidth();
double yScale = 300/image.getHeight();

AffineTransform transform = new AffineTransform();
transform.setToScale( xScale, yScale );
//paint code goes here