BufferedImage sourceImage = ImageIO.read("myImage");
BufferedImage overlayImage = ImageIO.read("myOverlay");

Graphics2D g2Source = sourceImage.createGraphics();
g2Source.drawImage(overlayImage, x, y, null);

g2Source.dispose();