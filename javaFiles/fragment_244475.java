import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RobotLocOnScreenTest{
    public static void main(String[] args){
        final JTextArea ta = new JTextArea(21, 12);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame f = new JFrame();
                JPanel p = new JPanel();
                JTextField tf = new JTextField("asadasdasd", 15);
                p.add(tf);
                p.add(ta);
                p.add(new JTextField(11));
                f.setContentPane(p);
                f.setSize(800, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                //request focus so the text field tf has it first
                tf.requestFocusInWindow();
            }
        });
        /* A hack to allow the GUI to build so we can see all robot's operations on the area 
        * and avoid the IllegalComponentStateException exception thrown by
        * Component.getLocationOnScreen() method when the component is not showing.
        */
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex) {
            Logger.getLogger(RobotLocOnScreenTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        findAndOperateOnTextArea(ta);           
    }

    private static void findAndOperateOnTextArea(JTextArea ta){
        try{
            Robot robot = new Robot();
            Point taLOSP = ta.getLocationOnScreen();
            Point taLPBad = ta.getLocation();
            SwingUtilities.convertPointToScreen(taLPBad, ta);           
            Point taLPGood = ta.getLocation();
            SwingUtilities.convertPointToScreen(taLPGood, ta.getParent());
            System.out.println("ta.getLocationOnScreen()=" + taLOSP 
                    + "; taLPBad=" + taLPBad+"; taLPGood="+taLPGood);           
            robot.mouseMove(taLOSP.x, taLOSP.y);
            robot.delay(1111);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_0);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_1);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_2);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_3);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_4);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_5);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_6);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_7);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_8);
            robot.delay(333);
            robot.keyPress(KeyEvent.VK_9);
        }catch(AWTException ex){
            Logger.getLogger(RobotLocOnScreenTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}