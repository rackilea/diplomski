BufferedImage totalImage = new BufferedImage(...);
 Graphics2D g = totalImage.createGraphics();
 String[] files = { ... };
 for (int i = 0; i < files.length; ++i) {
     BufferedImage img = ImageIO.read(files[i]);
     int x = i * 75;
     int y = 0;
     g.drawImage(x, y, img, ...);
 }
 ImageIO.write(totalImage, ...);
 g.dispose();