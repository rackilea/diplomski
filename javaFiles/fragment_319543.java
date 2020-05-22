/**
 * @see https://stackoverflow.com/q/14358499/230513
 * @see https://stackoverflow.com/a/12228640/230513
 */
private Icon getGray(Icon icon) {
    final int w = icon.getIconWidth();
    final int h = icon.getIconHeight();
    GraphicsEnvironment ge =
        GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    BufferedImage image = gc.createCompatibleImage(w, h);
    Graphics2D g2d = image.createGraphics();
    icon.paintIcon(null, g2d, 0, 0);
    Image gray = GrayFilter.createDisabledImage(image);
    return new ImageIcon(gray);
}