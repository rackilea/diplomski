import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Mainframe extends JComponent {

    private static final long serialVersionUID = 1L;

    int x = 350;
    int y = 250;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Mainframe");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setFocusable(true);
                frame.getContentPane().setBackground(Color.WHITE);
                frame.getContentPane().add(new Mainframe());
                frame.setVisible(true);
            }
        });
    }

    public Mainframe() {
        bindKeyWith("y.up", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), new VerticalAction(-1));
        bindKeyWith("y.down", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), new VerticalAction(1));
        bindKeyWith("x.left", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), new HorizontalAction(-1));
        bindKeyWith("x.right", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), new HorizontalAction(1));
    }

    protected void bindKeyWith(String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 100, 100);
    }

    public abstract class MoveAction extends AbstractAction {

        private int delta;

        public MoveAction(int delta) {
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }

        protected abstract void applyDelta();

        @Override
        public void actionPerformed(ActionEvent e) {
            applyDelta();
        }

    }

    public class VerticalAction extends MoveAction {

        public VerticalAction(int delta) {
            super(delta);
        }

        @Override
        protected void applyDelta() {
            int delta = getDelta();
            y += delta;
            if (y < 0) {
                y = 0;
            } else if (y + 100 > getHeight()) {
                y = getHeight() - 100;
            }
            repaint();
        }

    }
    public class HorizontalAction extends MoveAction {

        public HorizontalAction(int delta) {
            super(delta);
        }

        @Override
        protected void applyDelta() {
            int delta = getDelta();
            x += delta;
            if (x < 0) {
                x = 0;
            } else if (x + 100 > getWidth()) {
                x = getWidth() - 100;
            }
            repaint();
        }

    }
}