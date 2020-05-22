public void setLocationRelativeTo(ImageViewWindow imageWindow) {
    Point location = imageWindow.getLocation();

    int xOffSet = imageWindow.getFrame().getWidth();
    int yOffSet = 0;

    this.setLocation(xOffSet + location.x, yOffSet + location.y);
}