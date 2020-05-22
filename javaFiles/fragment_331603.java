public BufferedImage colorImage(BufferedImage loadImg, int red, int green, int blue) {
    BufferedImage img = new BufferedImage(loadImg.getWidth(), loadImg.getHeight(),
        BufferedImage.TRANSLUCENT);
    Graphics2D graphics = img.createGraphics(); 
    Color newColor = new Color(red, green, blue, 0 /* alpha needs to be zero */);
    graphics.setXORMode(newColor);
    graphics.drawImage(loadImg, null, 0, 0);
    graphics.dispose();
    return img;
}