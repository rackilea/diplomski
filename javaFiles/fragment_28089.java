BufferedImage dest = new BufferedImage(
    imageWidth, imageHeight,
    BufferedImage.TYPE_INT_ARGB);
Graphics2D g2 = dest.createGraphics();
g2.drawImage(image, 0, 0, null);
g2.dispose();