package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyPresser {

    public static void main(String[] args) 
    {
         try {
                Robot robot = new Robot();

                // Simulate the charms shortcut: WIN key+C
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_C);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
                robot.keyRelease(KeyEvent.VK_C);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        // TODO Auto-generated method stub

    }

}