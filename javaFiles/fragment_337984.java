adriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
StringSelection ss = new 
StringSelection("C:\\Users\\romit\\Desktop\\ELDEN\\LOGO.jpg");
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_CONTROL);
  Thread.sleep(2000);
robot.keyPress(KeyEvent.VK_V);
  Thread.sleep(2000);
robot.keyRelease(KeyEvent.VK_V);
  Thread.sleep(2000);
robot.keyRelease(KeyEvent.VK_CONTROL);
  Thread.sleep(2000);
robot.keyPress(KeyEvent.VK_ENTER);
  Thread.sleep(2000);
robot.keyRelease(KeyEvent.VK_ENTER);
  Thread.sleep(2000);