BufferedImage bufferedImage =
        new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);

Graphics2D g2 = bufferedImage.createGraphics();
g2.setColor(backColor);
g2.fillRect(0, 0, 5, 5);
g2.setColor(stripeColor);
g2.drawLine(0, 0, 5, 5); // \
g2.drawLine(0, 5, 5, 0); // /

// paint with the texturing brush
Rectangle2D rect = new Rectangle2D.Double(0, 0, 5, 5);
g2d.setPaint(new TexturePaint(bufferedImage, rect));
g2d.fill(shape);