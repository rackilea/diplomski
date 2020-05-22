// The required drawing location
int drawLocationX = 300;
int drawLocationY = 300;

// Rotation information

double rotationRequired = Math.toRadians (45);
double locationX = image.getWidth() / 2;
double locationY = image.getHeight() / 2;
AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

// Drawing the rotated image at the required drawing locations
g2d.drawImage(op.filter(image, null), drawLocationX, drawLocationY, null);