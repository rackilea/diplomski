Robot robot = new Robot();
// press key Ctrl+Shift+r
robot.keyPress(KeyEvent.VK_CONTROL);
robot.delay(100);
robot.keyPress(KeyEvent.VK_SHIFT);
robot.delay(100);
robot.keyPress(KeyEvent.VK_R);
// relase key Ctrl+Shift+r
robot.delay(100);
robot.keyRelease(KeyEvent.VK_R);
robot.delay(100);
robot.keyRelease(KeyEvent.VK_SHIFT);
robot.delay(100);
robot.keyRelease(KeyEvent.VK_CONTROL);