import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import java.awt.Robot; 
import java.awt.event.KeyEvent; 

public class Main {

    public static void main(String args[]) {
        // Create an instance of Robot class 
        Robot robot = new Robot();

        final JTextField textField = new JTextField();

        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                // Your code here
                // Press keys using robot. A gap of 
                // of 500 mili seconds is added after 
                // every key press 
                robot.keyPress(KeyEvent.VK_H); 
                Thread.sleep(500); 
                robot.keyPress(KeyEvent.VK_E); 
                Thread.sleep(500); 
                robot.keyPress(KeyEvent.VK_L); 
                Thread.sleep(500); 
                robot.keyPress(KeyEvent.VK_L); 
                Thread.sleep(500); 
                robot.keyPress(KeyEvent.VK_O);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Your code here
                textField.setText("");
            }
        });
    }
}