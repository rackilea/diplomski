private BufferedImage getImage(String name) {
    BufferedImage image;
    try {
        image = ImageIO.read(new File(name));
    } catch (IOException ioe) {
        return errorImage;
    }
    int w = image.getWidth();
    int h = image.getHeight();
    int max = Math.max(w, h);
    max = (int) Math.sqrt(2 * max * max);
    BufferedImage square = new BufferedImage(
            max, max, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = square.createGraphics();
    g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.drawImage(image, (max - w) / 2, (max - h) / 2, null);
    g2d.dispose();
    return square;
}