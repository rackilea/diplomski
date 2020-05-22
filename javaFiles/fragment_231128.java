public void moveToVisible(JFrame frame) {
    // Vertical position
    GraphicsDevice activeScreen = getGraphicsConfiguration().getDevice();
    if (frame.getLocation().y < 0) {
        frame.setLocation(getLocation().x, 0);
    }
    if ((frame.getLocation().y + frame.getHeight()) > 
            activeScreen.getDisplayMode().getHeight()) {
        frame.setLocation(
                frame.getLocation().x,
                (activeScreen.getDisplayMode().getHeight() 
                 - frame.getHeight())
        );
    }
    // Horizontal position
    int offsetRight = frame.getX() + frame.getWidth() - frame.getGraphicsConfiguration().getBounds().x + frame.getGraphicsConfiguration().getBounds().width;
    if (offsetRight > 0) {
        setLocation(frame.getX() - offsetRight, frame.getY());
    }
    int offsetLeft = frame.getX() - frame.getGraphicsConfiguration().getBounds().x;
    if (offsetLeft < 0) {
        frame.setLocation(frame.getX() - offsetLeft, frame.getY());
    }
}