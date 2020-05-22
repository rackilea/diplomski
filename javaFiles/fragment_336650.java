double xScale = 100/image.getWidth();
double yScale = 300/image.getHeight();
double theScale = xScale > yScale ? xScale : yScale;

AffineTransform transform = new AffineTransform();
transform.setToScale( theScale , theScale );
//paint code goes here