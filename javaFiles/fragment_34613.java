public GraphicsDevice getMonitorWindowIsOn(Window window)
{
    // First, grab the x,y position of the Window object
    GraphicsConfiguration windowGraphicsConfig = window.getGraphicsConfiguration();
    if (windowGraphicsConfig == null)
    {
         return null; // Should probably be handled better
    }
    Rectangle windowBounds = windowGraphicsConfig.getBounds();

    for (GraphicsDevice gd : ge.getScreenDevices()) {
        Rectangle monitorBounds = gd.getDefaultConfiguration().getBounds();
        if (monitorBounds.contains(windowBounds.x, windowBounds.y))
        {
            return gd;
        }
    }
    // um, return null I guess, should make this default better though,
    // maybe to the default screen device, except, I am sure if no monitors are
    // connected that may be null as well.
    return null;
}