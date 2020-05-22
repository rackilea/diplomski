// config is the LwjglApplicationConfiguration of the application

// upon changing using alt+enter
if(fullscreen) {
    config.resizable = false;
    Gdx.graphics.setUndecorated(true);
    Rectangle monitor = getMonitorFromWindow();
    // set to full screen in current monitor
    Gdx.graphics.setWindowedMode(monitor.width, monitor.height);
    Display.setLocation(monitor.x, monitor.y);
} else {
    config.resizable = true;
    Gdx.graphics.setUndecorated(false);
    Rectangle monitor = getMonitorFromWindow();
    // set to windowed centered in current monitor
    Gdx.graphics.setWindowedMode((int) (monitor.width * 0.8f), (int) (monitor.height * 0.8f));
    Display.setLocation(monitor.x + (int) (monitor.width * 0.1f), monitor.y + (int) (monitor.height * 0.1f));
}