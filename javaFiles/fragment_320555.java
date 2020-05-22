public static Rectangle getScreenViewableBounds(Window window) {
    return getScreenViewableBounds((Component) window);
}

public static Rectangle getScreenViewableBounds(Component comp) {
    return getScreenViewableBounds(getGraphicsDevice(comp));
}

public static Rectangle getScreenViewableBounds(GraphicsDevice gd) {
    Rectangle bounds = new Rectangle(0, 0, 0, 0);
    if (gd == null) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gd = ge.getDefaultScreenDevice();
    }

    if (gd != null) {
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        bounds = gc.getBounds();

        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        bounds.x += insets.left;
        bounds.y += insets.top;
        bounds.width -= (insets.left + insets.right);
        bounds.height -= (insets.top + insets.bottom);
    }

    return bounds;
}