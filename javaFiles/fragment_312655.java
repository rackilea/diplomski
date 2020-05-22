import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintTest extends JPanel{

    boolean blueSqr = false;

    PaintTest() {
        setPreferredSize(new Dimension(100,25));
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                blueSqr = !blueSqr;
                repaint();
            }
        };
        Timer timer = new Timer(1000,al);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        Color c = (blueSqr ? Color.BLUE : Color.RED);
        g.setColor(c);
        g.fillRect(10, 10, 10, 10);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame theWindow = new JFrame("Window");
                theWindow.getContentPane().add(new PaintTest());
                createWindow(theWindow);
            }
        });
    }

    public static void createWindow(JFrame theWindow){
        theWindow.pack();
        theWindow.setLocationByPlatform(true);
        theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theWindow.setVisible(true);
    }
}