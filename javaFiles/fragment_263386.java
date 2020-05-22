public void updatePanelSize() {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice();
    float monitorWidth = gd.getDisplayMode().getWidth();
    float monitorHeight = gd.getDisplayMode().getHeight();

    // Aspect ratio of the monitor in decimal form.
    float monitorRatio = monitorWidth / monitorHeight;

    JComponent parent = (JComponent) getParent();
    float width = parent.getWidth();
    float height = parent.getHeight();

    width = Math.min(width, height * monitorRatio);
    height = width / monitorRatio;

    // I am subtracting the width and height by their respective aspect ratio...
    int paddedWidth = (int) width - (16 * 10);
    int paddedHeight = (int) height - (9 * 10);
    setPreferredSize(new Dimension(paddedWidth, paddedHeight));

    int resultWidth = getWidth();
    int resultHeight = getHeight();
    if (paddedWidth != resultWidth && paddedHeight != resultHeight) {
        revalidate(); // preferred dimensions not applied, so force them
    }

    System.out.println("PreferredSize: " + paddedWidth + "x" + paddedHeight);
    System.out.println("PanelRes: " + resultWidth + "x" + resultHeight);
    System.out.println("PanelRatio: " + (float)resultWidth / resultHeight);
}