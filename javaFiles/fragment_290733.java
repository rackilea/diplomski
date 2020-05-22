AffineTransform at = new AffineTransform();
AffineTransform g2dAffineTransform = g2d.getTransform();
at.scale(2, 1);
at.rotate(Math.toRadians(45));
at = new AffineTransform(at);
at.translate(-img.getWidth()/2, -img.getHeight()/2);
g2D.setTransform(at);
g2D.drawImage(img, 0, 0, null);
g2D.drawImage(img, 16, 0, null);
g2D.drawImage(img, 32, 0, null);

//Reset the transform
g2d.setTransform(g2dAffineTransform);
//All rendering with this g2d is now at the original coordinate system
//g2d.draw...
g2D.dispose();