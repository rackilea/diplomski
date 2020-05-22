public static void takePictureOfError(String Name) throws IOException,
        AWTException {
    new File("Errors").mkdir();
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    Rectangle screenRect = new Rectangle(screenSize);
    Robot robot = new Robot();
    BufferedImage image = robot.createScreenCapture(screenRect);
    utilsLogger.info(ImageIO.write(image, "png", new File("//"
            + Name)));
}