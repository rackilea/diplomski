public static boolean isValid(String imageUrl) throws IOException, InterruptedException {
    URL url = new URL(imageUrl);
    Image img = ImageIO.read(url);
    //img = img.getScaledInstance(100, -1, Image.SCALE_FAST);
    int w = img.getWidth(null);
    int h = img.getHeight(null);
    int[] pixels = new int[w * h];
    PixelGrabber pg = new PixelGrabber(img, 0, 0, w, h, pixels, 0, w);
    pg.grabPixels();
    boolean isValid = false;
    for (int pixel : pixels) {
        Color color = new Color(pixel);
        if (color.getAlpha() == 0 || color.getRGB() != Color.WHITE.getRGB()) {
            isValid = true;
            break;
        }
    }
    return isValid;
}