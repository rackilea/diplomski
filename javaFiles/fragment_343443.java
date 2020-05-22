import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Snake {

    public static void main(String[] args) {
        new Snake();
    }

    public Snake() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        public enum Direction {

            UP, DOWN, LEFT, RIGHT
        }

        private int xPos, yPos;

        private Direction direction = Direction.UP;

        private LinkedList<Point> snakeBody = new LinkedList<>();

        public TestPane() {
            xPos = 100;
            yPos = 100;

            for (int index = 0; index < 50; index++) {
                snakeBody.add(new Point(xPos, yPos));
            }

            bindKeyStrokeTo("up.pressed", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), new MoveAction(Direction.UP));
            bindKeyStrokeTo("down.pressed", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), new MoveAction(Direction.DOWN));

            bindKeyStrokeTo("left.pressed", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), new MoveAction(Direction.LEFT));
            bindKeyStrokeTo("right.pressed", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), new MoveAction(Direction.RIGHT));

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (direction) {
                        case UP:
                            yPos--;
                            break;
                        case DOWN:
                            yPos++;
                            break;
                        case LEFT:
                            xPos--;
                            break;
                        case RIGHT:
                            xPos++;
                            break;
                    }
                    if (yPos < 0) {
                        yPos--;
                    } else if (yPos > getHeight() - 1) {
                        yPos = getHeight() - 1;
                    }
                    if (xPos < 0) {
                        xPos--;
                    } else if (xPos > getWidth() - 1) {
                        xPos = getWidth() - 1;
                    }

                    snakeBody.removeLast();
                    snakeBody.push(new Point(xPos, yPos));
                    repaint();
                }
            });
            timer.start();
        }

        public void bindKeyStrokeTo(String name, KeyStroke keyStroke, Action action) {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(keyStroke, name);
            am.put(name, action);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (Point p : snakeBody) {
                g2d.drawLine(p.x, p.y, p.x, p.y);
            }
            g2d.dispose();
        }

        public class MoveAction extends AbstractAction {

            private Direction moveIn;

            public MoveAction(Direction direction) {
                this.moveIn = direction;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                direction = this.moveIn;
            }

        }

    }

}