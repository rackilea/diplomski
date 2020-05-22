BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
Graphics2D g2 = bi.createGraphics();
g2.setColor( Color.BLACK );
g2.setStroke(new BasicStroke(5));
g2.drawLine(4,4,95,95);
g2.drawLine(4,95,95,4);
ImageIcon icon = new ImageIcon( bi );