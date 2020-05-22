Robot robot = new Robot();
// press and hold CONTROL key
robot.keyPress(KeyEvent.VK_CONTROL);

// Left Click
robot.mousePress(InputEvent.BUTTON1_MASK);
robot.mouseRelease(InputEvent.BUTTON1_MASK); 

// release CONTROL key
robot.keyRelease(KeyEvent.VK_CONTROL);