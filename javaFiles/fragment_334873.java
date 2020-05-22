public void setCursorSize(int w, int h) {
    this.cw = w;
    this.ch = h;
    if (w > 32) {
        w = 32;
    }
    if (h > 32) {
        h = 32;
    }
    Color tc = new Color(0, 0, 0, 0);
    BufferedImage im = new BufferedImage(32, 32, BufferedImage.TYPE_4BYTE_ABGR);//cursor size is 32X32
    for (int x = 0; x < 32; x++) {
        for (int y = 0; y < 32; y++) {
            im.setRGB(x, y, tc.getRGB());
        }
    }
    for (int x = 16 - w / 2; x <= 16 + w / 2; x++) {
        for (int y = 16 - h / 2; y <= 16 + h / 2; y++) {
            im.setRGB(x, y, new Color(255, 0, 0).getRGB());
        }
    }
    this.setCursor(getToolkit().createCustomCursor(im, new Point(16, 16), "c1"));
}