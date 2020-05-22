private void capturePane() {
    try {
        Bounds bounds = pane.getBoundsInLocal();
        Bounds screenBounds = pane.localToScreen(bounds);
        int x = (int) screenBounds.getMinX();
        int y = (int) screenBounds.getMinY();
        int width = (int) screenBounds.getWidth();
        int height = (int) screenBounds.getHeight();
        Rectangle screenRect = new Rectangle(x, y, width, height);
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        ImageIO.write(capture, "png", new File("image.png"));
    } catch (IOException | AWTException ex) {
        ex.printStackTrace();
    }
}