import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DemoWindows implements ActionListener {

    public static void main(String[] args) {
        // create a new demo, and update it every 50 mSec
        new Timer(30, new DemoWindows()).start();
    }
    int phase = 0; // demo runs a number of consecutive phases
    int count = 0; // each of which takes a number of timesteps
    JFrame window1 = new JFrame("Java windows demo");
    JLabel text1 = new JLabel("<HTML><H1>Hello" + "<BR>Everyone");
    // "<HTML><H1>This is a demo of some of the effects"
    // + "<BR>that can be achieved with the new Java"
    // + "<BR>transparent window methods</H1>"
    // + "<BR>(requires latest version of Java)");
    JFrame window2 = new JFrame("Java windows demo");
    JLabel text2 = new JLabel("<HTML><center>Java<BR>rocks");
    JButton button = new JButton("Whatever");
    int w, h, r, x, y; // parameters of iris circle

    DemoWindows() {
        // build and diplay the windows
        window1.add(text1);
        window1.pack();
        window1.setLocationRelativeTo(null);
        window1.setVisible(true);
        window2.setUndecorated(true);
        window2.setBackground(new Color(0, 0, 0, 0)); // alpha <1 = transparent
        window2.setOpacity(0.0f);
        text2.setFont(new Font("Arial", 1, 60));
        text2.setForeground(Color.red);
        window2.add(text2);
        window2.add(button, BorderLayout.SOUTH);
        window2.pack();
        window2.setLocationRelativeTo(null);
        window2.setVisible(true);
        // parameters of the smallest circle that encloses window2
        // this is the starting pouint for the "iris out" effect
        w = window2.getWidth();
        h = window2.getHeight();
        r = (int) Math.sqrt(w * w + h * h) / 2; // radius
        x = w / 2 - r; // top left coordinates of circle
        y = h / 2 - r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {// L&F changed on Runtime, repeatly fired from Swing Timer 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DemoWindows.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DemoWindows.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DemoWindows.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DemoWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(window2);
        // called by timer 20 times per sec
        // goes thru a number of phases, each a few seconds long
        switch (phase) {
            case 0: { // initial pause               
                if (++count > 50) {
                    phase = 1; // go to next phase
                    count = 0;
                }
                break;
            }
            case 1: { // fade in               
                if (++count < 100) {
                    window2.setOpacity(0.01f * count);
                } else {
                    phase = 2; // go to next phase
                    count = 0;
                }
                break;
            }
            case 2: { // move               
                if (++count < 160) {
                    if (count < 28 || count > 80) {// pause for best effect
                        window2.setLocation(window2.getX() + 1, window2.getY() + 1);
                    }
                } else {
                    phase = 3; // go to next phase
                    count = 0;
                }
                break;
            }
            case 3: {// iris out                
                if (++count < r) {
                    Shape shape = new Ellipse2D.Double(
                            x + count, y + count, 2 * (r - count), 2 * (r - count));
                    window2.setShape(shape);
                } else {
                    phase = 99; // go to final (exit) phase
                }
                break;
            }
            case 99:
                System.exit(0);
        }
    }
}