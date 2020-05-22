public void firePlay() {
    //CTRL + P
    //import java.awt.Robot
    //import java.awt.KeyEvent
    try {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    } catch (AWTException ex) {
        Logger.getLogger(atest.class.getName()).log(Level.SEVERE, null, ex);
    }
}