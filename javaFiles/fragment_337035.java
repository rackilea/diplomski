Point point = event.getPoint();

GraphicsEnvironment e 
     = GraphicsEnvironment.getLocalGraphicsEnvironment();

GraphicsDevice[] devices = e.getScreenDevices();

Rectangle displayBounds = null;

//now get the configurations for each device
for (GraphicsDevice device: devices) { 

    GraphicsConfiguration[] configurations =
        device.getConfigurations();
    for (GraphicsConfiguration config: configurations) {
        Rectangle gcBounds = config.getBounds();

        if(gcBounds.contains(point)) {
            displayBounds = gcBounds;
        }
    }
}

if(displayBounds == null) {
    //not found, get the bounds for the default display
    GraphicsDevice device = e.getDefaultScreenDevice();

    displayBounds =device.getDefaultConfiguration().getBounds();
}
//do something with the bounds
...