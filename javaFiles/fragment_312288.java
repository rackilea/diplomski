BufferedImage img1 = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
BufferedImage img2 = new BufferedImage(400, 200, BufferedImage.TYPE_INT_ARGB);

double sx = img2.getWidth() / (double) img1.getWidth();
double sy = img2.getHeight() / (double) img1.getHeight();

AffineTransformOp xform = 
        new AffineTransformOp(AffineTransform.getScaleInstance(sx, sy), null);
Point srcPt = new Point(7, 49);
Point dstPoint = (Point) xform.getPoint2D(srcPt, new Point());

System.err.println("srcPt: " + srcPt);
System.err.println("dstPoint: " + dstPoint);