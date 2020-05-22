GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gdUpperRight = null;
Rectangle bUpperRight = null;
for (GraphicsDevice gd : ge.getScreenDevices()) {
    Rectangle b = gd.getDefaultConfiguration().getBounds();
    if (bUpperRight == null || b.x > bUpperRight.x || b.y > bUpperRight.y) {
        bUpperRight = b;
        gdUpperRight = gd;
    }
}

gdUpperRight.setFullScreenWindow(myFrame);