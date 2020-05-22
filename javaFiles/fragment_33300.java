c.setSize(c.getPreferredSize());
BufferedImage img = new BufferedImage(c.getWidth(), c.getHeight(), 
      BufferedImage.TYPE_INT_ARGB);
Graphics2D g = image.createGraphics();
g.setComposite(AlphaComposite.Clear);
g.fillRect(0, 0, c.getWidth(), c.getHeight());
g.setComposite(AlphaComposite.SrcOver);
c.paintComponent(g);
g.dispose();