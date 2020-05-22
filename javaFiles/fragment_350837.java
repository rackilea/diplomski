GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
int x = (int)rect.getMinX();
int y = (int)rect.getMaxY()-frame.getHeight();
frame.setLocation(x,y);