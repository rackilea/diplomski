public static BufferedImage convertToType(BufferedImage image, int type) {
    BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), type);
    Graphics2D graphics = newImage.createGraphics();
    graphics.drawImage(image, 0, 0, null);
    graphics.dispose();
    return newImage;
}