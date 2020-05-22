GraphicsDevice[] screens = GraphicsEnvironment
    .getLocalGraphicsEnvironment()
    .getScreenDevices();

for (GraphicsDevice screen:screens)
    System.out.println(screen.getDefaultConfiguration().getBounds());