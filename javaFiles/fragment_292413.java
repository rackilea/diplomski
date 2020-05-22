import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotWrapper {

    private static final int STD_DELAY = 35000;

    private final Robot robot;

    public RobotWrapper() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void doStuff(int x, int y) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(STD_DELAY);
    }

    public static void main(String[] args) {
        RobotWrapper robotWrapper = new RobotWrapper();
        robotWrapper.doStuff(16, 853);
        robotWrapper.doStuff(100, 200);
    }
}