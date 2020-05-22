Robot robot = new Robot();

robot.setAutoWaitForIdle(true);
robot.setAutoDelay(40);

robot.keyPress(KeyEvent.VK_ALT);//on mac use VK_META
robot.keyPress(KeyEvent.VK_TAB);
robot.keyRelease(KeyEvent.VK_ALT);//on mac use VK_META
robot.keyRelease(KeyEvent.VK_TAB);

robot.keyPress(KeyEvent.VK_A);
robot.delay(200);
robot.keyRelease(KeyEvent.VK_A);