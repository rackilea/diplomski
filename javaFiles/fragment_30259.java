import java.awt.*;
import java.awt.event.*;

public class Test11 extends Frame {

    public Test11(String title) {
        super(title);
        setSize(400, 400);
        setBackground(Color.red);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println(
                    getTitle() +
                    " says Bye-Bye!  " +
                    new java.util.Date());
                dispose();
            }
        });
        setLocationByPlatform(true);
    }

    public static void main(String[] args) {
        /* AFAIU starting the GUI on the EDT only applies to Swing.*/
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Run: Window 1");
                (new Test11("Window 1")).setVisible(true);
                System.out.println("Run: Window 2");
                (new Test11("Window 2")).setVisible(true);
            }
        });
    }
}