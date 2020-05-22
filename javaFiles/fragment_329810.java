BufferedImage before = getBufferedImage(encoded);
int w = before.getWidth();
int h = before.getHeight();
BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
AffineTransform at = new AffineTransform();
at.scale(2.0, 2.0);
AffineTransformOp scaleOp = 
   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
after = scaleOp.filter(before, after);