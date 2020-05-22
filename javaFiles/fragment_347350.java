BufferedImage bufImg = ImageIO.read( imageFile );
BufferedImage convertedImg = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = convertedImg.createGraphics();
g2d.drawImage(bufImg, 0, 0, null);
g2d.dispose();
....
///now feed convertedImg  into the CannyEdgeDetectory
detector.setSourceImage(convertedImg);