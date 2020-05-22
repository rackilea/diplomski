import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new Class2());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Class2
            extends JPanel
            implements ActionListener {

        int x = 0, vx = 0, y = 0, vy = 0;
        Timer t = new Timer(5, this);

        public Class2() {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            am.put("left", new LeftAction());
            am.put("right", new RightAction());
            am.put("up", new UpAction());
            am.put("down", new DownAction());

            // Stop movement when key is released
            am.put("stopHorizontal", new StopHorizontalAction());
            am.put("stopVertical", new StopVerticalAction());

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "stopHorizontal");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "stopHorizontal");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "stopVertical");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "stopVertical");

            t.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            g.fillOval(x, y, 50, 50);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            x += vx;
            y += vy;
            repaint();
        }

        protected class StopHorizontalAction extends AbstractAction {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                vx = 0;
            }
        }

        protected class StopVerticalAction extends AbstractAction {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                vy = 0;
            }
        }

        protected class MovementAction extends AbstractAction {

            private Integer xDelta;
            private Integer yDelta;

            public MovementAction(Integer xDelta, Integer yDelta) {
                this.xDelta = xDelta;
                this.yDelta = yDelta;
            }

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (xDelta != null) {
                    vx += xDelta;
                }
                if (yDelta != null) {
                    vy += yDelta;
                }
            }

        }

        protected class LeftAction extends MovementAction {

            public LeftAction() {
                super(-1, null);
            }

        }

        protected class RightAction extends MovementAction {

            public RightAction() {
                super(1, null);
            }

        }

        protected class UpAction extends MovementAction {

            public UpAction() {
                super(null, -1);
            }

        }

        protected class DownAction extends MovementAction {

            public DownAction() {
                super(null, 1);
            }

        }

    }
}