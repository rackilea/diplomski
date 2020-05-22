BufferedImage after = new BufferedImage(lightmap.getWidth()*10, lightmap.getHeight()*10, BufferedImage.TYPE_INT_ARGB);
AffineTransform at = new AffineTransform();
at.scale(10, 10);
AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
after = scaleOp.filter(lightmap, after);
g.drawImage(after,0,0,null);