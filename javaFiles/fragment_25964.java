GraphicsEnvironment ge = GraphicsEnvironment
        .getLocalGraphicsEnvironment();
GraphicsDevice[] gs = ge.getScreenDevices();

for (int i = 0; i < gs.length; i++) {
    DisplayMode dm = gs[i].getDisplayMode();

    // Get refresh rate in Hz
    int refreshRate = dm.getRefreshRate();
    if (refreshRate == DisplayMode.REFRESH_RATE_UNKNOWN) {
        // Unknown rate
    } else {
        System.out.println(refreshRate);
    }
}