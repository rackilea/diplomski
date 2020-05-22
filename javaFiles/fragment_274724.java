try {
    Robot robot = new Robot();

    // Simulate a mouse click
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);

    // Simulate a key press
    robot.keyPress(KeyEvent.VK_SHIFT);
    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_SHIFT);
} catch (AWTException e) {
    e.printStackTrace();
}