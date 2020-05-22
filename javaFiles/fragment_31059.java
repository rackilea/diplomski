/**
 * This will render the splash for longer than just loading components
 *
 * @return true if there is a splash screen file supplied (set via java or
 * manifest) or false if not
 * @throws IllegalStateException
 */
private boolean showSplash() throws IllegalStateException {
    final SplashScreen splash = SplashScreen.getSplashScreen();
    if (splash == null) {
        return false;
    }
    Graphics2D g = splash.createGraphics();
    if (g == null) {
        return false;
    }
    for (int i = 0; i < 100; i++) {//loop 100 times and sleep 50 thus 100x50=5000milis=5seconds
        renderSplashFrame(g);
        splash.update();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
    splash.close();
    return true;
}

private void renderSplashFrame(Graphics2D g2d) {
    //draw anyhting else here
}