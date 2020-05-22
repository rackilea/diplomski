try {
    String format = "jpg";
    String fileName = printScreen." + format;

    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    Robot robot = new Robot();
    BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
    ImageIO.write(screenFullImage, format, new File(fileName));

} catch (AWTException | IOException ex) {
    System.err.println(ex);
}