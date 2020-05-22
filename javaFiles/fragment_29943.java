// find the display device of interest
final GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

// on OS X, it would be CGraphicsDevice
if (defaultScreenDevice instanceof CGraphicsDevice) {
    final CGraphicsDevice device = (CGraphicsDevice) defaultScreenDevice;

    // this is the missing correction factor, it's equal to 2 on HiDPI a.k.a. Retina displays
    final int scaleFactor = device.getScaleFactor();

    // now we can compute the real DPI of the screen
    final double realDPI = scaleFactor * (device.getXResolution() + device.getYResolution()) / 2;
}