import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.awt.*;
import java.util.*;
import java.lang.reflect.Field;
import java.awt.event.*;
import javax.swing.*;

public class RobotClicker {
    Robot robot = new Robot();

    public static void main(String[] args) throws AWTException {
        new RobotClicker();
    }

    public RobotClicker() throws AWTException {
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        for (int i = 0; i < 7476; i++) {
            String holding = Integer.toString(i);
            Robot robot = new Robot();

            robot.delay(4000);
            robot.mouseMove(144, 400);
            robot.delay(500);

            leftClick();
            //robot.delay(500);
            leftClick();

            robot.delay(10);


            type(holding);

            robot.mouseMove(450, 480);
            robot.delay(10);

            leftClick();
            robot.delay(500);
            leftClick();

            robot.delay(1000);
        }
        System.exit(0);
    }

    private void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }

    private void type(int i) {
        robot.delay(40);
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    private void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    public static void typeCharacter(Robot robot, String letter) {
        try {
            boolean upperCase = Character.isUpperCase(letter.charAt(0));
            String variableName = "VK_" + letter.toUpperCase();

            Class clazz = KeyEvent.class;
            Field field = clazz.getField(variableName);
            int keyCode = field.getInt(null);

            robot.delay(1000);

            if (upperCase)
                robot.keyPress(KeyEvent.VK_SHIFT);

            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);

            if (upperCase)
                robot.keyRelease(KeyEvent.VK_SHIFT);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}