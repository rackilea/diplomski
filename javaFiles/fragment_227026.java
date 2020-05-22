if (view.isHover()) {
    Point pointerLocation = MouseInfo.getPointerInfo().getLocation();

    int sceneX = pointerLocation.x;
    sceneX -= view.getScene().getWindow().getX();
    sceneX -= view.getScene().getX();

    int sceneY = pointerLocation.y;
    sceneY -= view.getScene().getWindow().getY();
    sceneY -= view.getScene().getY();

    return new Point(sceneX, sceneY);
} else {
    // mouse not in view
}