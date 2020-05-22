import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

    public class TestPane extends JPanel {

        private Timer timer;
        private int a = 5, b = 5;
        private Random rand;
        private Circle circ = new Circle();

        public TestPane() {
            timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moveWithTimer();
                    repaint();
                }
            });
            timer.start();

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "spaced");
            am.put("spaced", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    circ.randomColor();
                    repaint();
                }
            });
        }

        public void moveWithTimer() {
            int x = circ.getX();
            int y = circ.getY();

            x = x + b;
            y = y + a;
            if (x < 0) {
                b = 5;
            }

            if (x + 50 > 500) {
                b = -5;
            }

            if (y < 0) {
                a = 5;
            }

            if (y + 50 > 500) {
                a = -5;
            }

            circ.setX(x);
            circ.setY(y);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            circ.paint(g2d);
            g2d.dispose();
        }

    }

    public class Circle {

        private int x, y, r;
        private Color co;
        private int Re, G, B;
        private Random ran;

        public Circle() {
            // TODO Auto-generated constructor stub
            ran = new Random();
            x = 100;
            y = 50;
            r = ran.nextInt(50) + 50;
            Re = ran.nextInt(255);
            G = ran.nextInt(255);
            B = ran.nextInt(255);
            co = new Color(Re, G, B);
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(co);
            g2d.fillOval(x, y, r * 2, r * 2);
        }

        public int getRe() {
            return Re;
        }

        public int getG() {
            return G;
        }

        public int getB() {
            return B;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getR() {
            return r;
        }

        public void randomColor() {
            setCo(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
        }

        public void setCo(int Re, int G, int B) {
            co = new Color(Re, G, B);
        }

        public Color getCo() {
            return co;
        }

        public Random getRan() {
            return ran;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

    }

}