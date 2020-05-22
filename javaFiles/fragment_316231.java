Image img1 = imageIcon1.getImage();
Image img2 = imageIcon2.getImage();

BufferedImage resultImage = new BufferedImage(
    img1.getWidth(null), img1.getHeight(null), BufferedImage.TYPE_INT_ARGB);

Graphics2D g = resultImage.createGraphics();
g.drawImage(img1, 0, 0, null);
g.drawImage(img2, 0, 0, null);
g.dispose();

ImageIcon resultImageIcon = new ImageIcon(resultImage);