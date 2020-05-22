BufferedImage image = new BufferedImage(theWidth, theHheight, BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = image.createGraphics();
g2d.setColor( Color.WHITE );
g2d.fillRect(0, 0, theWidth, theHeight);
g2d.setColor( Color.Black );
g2d.drawLine(...);
g2d.dispose();