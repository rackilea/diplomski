public static BufferedImage cropImage(BufferedImage src, Rectangle rect) {
    int w = (rect.x + rect.width > src.getWidth()) ? src.getWidth() - rect.x : rect.width;
    int h = (rect.y + rect.height > src.getHeight()) ? src.getHeight()- rect.y : rect.height;
    BufferedImage dest = src.getSubimage(rect.x, rect.y, w, h);
    return dest;
}