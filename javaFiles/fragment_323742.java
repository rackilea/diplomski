private static BufferedImage scaleImageTo(
    BufferedImage image, int width, int height) 
{
    BufferedImage scaledImage =
        new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = scaledImage.createGraphics();
    g.setRenderingHint(
        RenderingHints.KEY_INTERPOLATION, 
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(image, 0, 0, width, height, null);
    g.dispose();
    return scaledImage;
}