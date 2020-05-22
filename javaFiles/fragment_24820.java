BufferedImage image = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);
Graphics2D graphics = image.createGraphics();

graphics.setPaint(new Color(0, 0, 128));
graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

ImageIcon imageIcon = new ImageIcon(image);