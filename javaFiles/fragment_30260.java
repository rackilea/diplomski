import java.awt.*;
import java.awt.event.*;
// since the OP has not taken the time to explain 'why AWT',
// I choose to make life easy by using a Swing class.
import javax.swing.Timer;

public class Test11 extends Frame
{
    public static Frame window1;
    public static Frame window2;

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
        // AFAIU starting the GUI on the EDT only applies to Swing.
        //EventQueue.invokeLater(new Runnable() {
        //    public void run() {
                System.out.println("Run: Window 1");
                window1 = new Test11("Window 1");
                window1.setVisible(true);

                System.out.println("Run: Window 2");
                window2 = new Test11("Window 2");
                window2.setVisible(true);
        //    }
        //});

        //ActionListener closeWindow = new ActionListener(){
        //  public void actionPerformed(ActionEvent ae) {
                System.out.println(
                    window2.getTitle() +
                    " says Bye-Bye!  " +
                    new java.util.Date());
                /* failed then try */
                window2.dispose();
        //  }
        //};
        //Timer timer = new Timer(2000,closeWindow);
        //timer.setRepeats(false);
        //timer.start();
    }
}