package keyCodeTester;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyCodeTester {
    public static void main(String args[]) throws Exception {
        Robot robot = new Robot();
        robot.delay(5000);

        for(int i=41; i<10000000; i++) {
            try {
                if (i>=112 && i<=123) {
                    throw new IllegalArgumentException("touche fonction");
                }
                robot.keyPress(i);
                robot.delay(100);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.delay(100);
            } catch (IllegalArgumentException iae) {
                System.out.println("iae pour " + String.valueOf(i));
            }
        }

    }
}