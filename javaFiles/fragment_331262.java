import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RobotTest extends JFrame
{
    JTextField bookIDText;

    public RobotTest() throws AWTException
    {
        final Robot robot = new Robot();
        bookIDText = new JTextField();
        this.add(bookIDText);
        bookIDText.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                String words = bookIDText.getText().toString();
                System.out.println("Action on " + words);
                if (words.equals("W"))
                {
                    System.out.println("Pressing key");
                    robot.keyPress(KeyEvent.VK_H);
                }
            }
        } );
    }

    public static void main(String[] args) throws Exception
    {
        RobotTest frame = new RobotTest();
        frame.pack();
        frame.setVisible(true);
        frame.setResizable( false );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}