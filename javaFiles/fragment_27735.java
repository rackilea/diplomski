public static BufferedImage getScreenShot(Component component) throws AWTException {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    Robot robot = new Robot(gd);
    Rectangle bounds = new Rectangle(component.getLocationOnScreen(), component.getSize());
    return robot.createScreenCapture(bounds);
}