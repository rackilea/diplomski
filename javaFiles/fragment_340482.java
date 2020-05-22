static boolean windowFitsOnScreen(Window w) {
    return w.getGraphicsConfiguration().getBounds().contains(w.getBounds());
}

static void centerWindowToScreen(Window w) {
    Rectangle screen = w.getGraphicsConfiguration().getBounds();
    w.setLocation(
        screen.x + (screen.width - w.getWidth()) / 2,
        screen.y + (screen.height - w.getHeight()) / 2
    );
}