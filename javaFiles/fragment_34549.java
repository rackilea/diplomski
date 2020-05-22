public static BufferedImage rotate(BufferedImage image, double angle) {
    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
    int w = image.getWidth();
    int h = image.getHeight();
    int newW = (int) Math.floor(w * cos + h * sin);
    int newH = (int) Math.floor(h * cos + w * sin);
    GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                                                  .getDefaultScreenDevice()
                                                  .getDefaultConfiguration();

    BufferedImage result = gc.createCompatibleImage(newW, newH, Transparency.TRANSLUCENT);
    Graphics2D g = result.createGraphics();
    g.translate((newW - w) / 2, (newH - h) / 2);
    g.rotate(angle, w/2, h/2);
    g.drawRenderedImage(image, null);
    g.dispose();
    return result;
}