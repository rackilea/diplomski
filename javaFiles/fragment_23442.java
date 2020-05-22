import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public void clikOKOfConfirmationDialog(){
try {
    Robot robot = new Robot();
    robot.delay(2000);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
} catch (AWTException e) {
    e.printStackTrace();
 }
}