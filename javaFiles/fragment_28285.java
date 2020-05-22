Container content = frm.getContentPane();
BufferedImage img = new BufferedImage(container.getWidth(), container.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = img.createGraphics();

content.printAll(g2d);

g2d.dispose();