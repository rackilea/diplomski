static void setLocationToTopRight(JFrame frame) {
    GraphicsConfiguration config = frame.getGraphicsConfiguration();
    Rectangle bounds = config.getBounds();
    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);

    int x = bounds.x + bounds.width - insets.right - frame.getWidth();
    int y = bounds.y + insets.top;
    frame.setLocation(x, y);
}