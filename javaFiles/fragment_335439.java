import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimpleKeyTest {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();

                frame.getContentPane().add(panel);

                panel.addKeyListener(new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {}

                    @Override
                    public void keyReleased(KeyEvent e) {}

                    @Override
                    public void keyPressed(KeyEvent e) {
                        System.out.println("Pressed " + e.getKeyChar());
                    }
                });

                panel.setFocusable(true);
                panel.requestFocusInWindow();

                frame.setSize(new Dimension(300, 300));
                frame.setVisible(true);
            }

        };

        SwingUtilities.invokeLater(r);

    }
}