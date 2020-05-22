GraphicsConfiguration graphicsConfiguration = null;
for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
    if (gd.getDefaultConfiguration().getBounds().contains(p)) {
        graphicsConfiguration = gd.getDefaultConfiguration();
        break;
    }
}