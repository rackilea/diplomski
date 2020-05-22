Component comp = ...;
BufferedImage image = new BufferedImage(comp.getWidth(), comp.getHeight(),
    BufferedImage.TYPE_INT_RGB);
Graphics2D g = image.createGraphics();
comp.paint(g);
g.dispose();