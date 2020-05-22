import java.awt.*;
import java.awt.event.KeyEvent;

private void openExtension() throws AWTException {
    Robot robot = new Robot();

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_SHIFT);
    robot.keyPress(KeyEvent.VK_Y);
}