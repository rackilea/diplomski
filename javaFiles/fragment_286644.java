public static BufferedImage printScrAroundCursor(int width, int height)
{
    Toolkit tool = Toolkit.getDefaultToolkit();
    Robot robot = new Robot();

    PointerInfo a = MouseInfo.getPointerInfo();
    Point b = a.getLocation();
    int x = (int) b.getX();
    int y = (int) b.getY();

    int topLeftX = Math.max(0, x - (width / 2));
    int topLeftY = Math.max(0, y - (height / 2));
    if (topLeftX + width > tool.getScreenSize().getWidth())
        width = tool.getScreenSize().getWidth() - topLeftX;
    if (topLeftX + width > tool.getScreenSize().getHeight())
        width = tool.getScreenSize().getHeight() - topLeftY;
    return robot.createScreenCapture(new Rectangle(topLeftX , topLeftY , width, height));
}