import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/** @see http://stackoverflow.com/questions/7456227 */
public class FullScreenTest extends JPanel {

    private static final String EXIT = "Exit";
    private JFrame f = new JFrame("FullScreenTest");
    private Action exit = new AbstractAction(EXIT) {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispatchEvent(new WindowEvent(
                    f, WindowEvent.WINDOW_CLOSING));
            }
        };
    private JButton b = new JButton(exit);

    public FullScreenTest() {
        this.add(b);
        f.getRootPane().setDefaultButton(b);
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), EXIT);
        this.getActionMap().put(EXIT, exit);
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                FullScreenTest.this.setToolTipText(
                    "("+ e.getX() + "," + e.getY() + ")");
            }
        });
    }

    private void display() {
        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice dev = env.getDefaultScreenDevice();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.darkGray);
        f.setResizable(false);
        f.setUndecorated(true);
        f.add(this);
        f.pack();
        dev.setFullScreenWindow(f);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FullScreenTest().display();
            }
        });
    }
}