int x = 200;
int y = 100;
int width = 50;
int height = 30;
double theta = Math.toRadians(45);

// create rect centred on the point we want to rotate it about
Rectangle2D rect = new Rectangle2D.Double(-width/2., -height/2., width, height);

AffineTransform transform = new AffineTransform();
transform.rotate(theta);
transform.translate(x, y); 
// it's been while, you might have to perform the rotation and translate in the
// opposite order

Shape rotatedRect = transform.createTransformedShape(rect);

Graphics2D graphics = ...; // get it from whatever you're drawing to

graphics.draw(rotatedRect);