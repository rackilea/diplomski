Robot robot = new Robot();
    StringSelection selection = new StringSelection("Absolute path of the file");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
    robot.setAutoDelay(2000);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);