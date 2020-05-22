BufferedImage buffer = ImageIO.read(new File(file));
AffineTransform tx = new AffineTransform();
//tx.scale(scalex, scaley);
//tx.shear(shiftx, shifty);
//tx.translate(x, y);
tx.rotate(radians, buffer.getWidth()/2, buffer.getHeight()/2);

AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
buffer = op.filter(buffer, null);