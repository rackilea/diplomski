public BufferedImage resizeExact(final BufferedImage original, final Dimension scaled, final Dimension offset) {
    final Image newImage = original.getScaledInstance(scaled.width, scaled.height, Image.SCALE_SMOOTH);
    final BufferedImage bufferedImage = new BufferedImage(newImage.getWidth(null),
                                                          newImage.getHeight(null),
                                                          BufferedImage.TYPE_INT_BGR);
    bufferedImage.createGraphics().drawImage(newImage, offset.width, offset.height, null);
    return bufferedImage;
}