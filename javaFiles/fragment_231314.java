WebDriver driver = new FirefoxDriver();
driver.get("http://www.baidu.com/");

Robot robot = new Robot();

// press Ctrl+S the Robot's way
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_S);
robot.keyRelease(KeyEvent.VK_CONTROL);
robot.keyRelease(KeyEvent.VK_S);

Thread.sleep(2000L);

// press Enter
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);