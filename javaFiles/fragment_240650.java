//Image img = new ImageIcon("colorado.jpg").getImage();
//BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
BufferedImage bi = ImageIO.read(new File("colorado.jpg"));
Graphics2D g2d = bi.createGraphics();

g2d.setColor(Color.red);
g2d.fill(new Ellipse2D.Float(0, 0, 100, 100));
g2d.dispose();

ImageIO.write(bi, "jpg", new File("new.jpg"));