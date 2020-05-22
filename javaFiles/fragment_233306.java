// Robot
    Robot robot = new Robot();

    double x = 0;
    double y = 0;

    x = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
    y = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;

    int xx = (int) Math.round(x);
    int yy = (int) Math.round(y);

    robot.mouseMove(xx, yy);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.keyPress(KeyEvent.VK_Y);