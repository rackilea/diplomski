import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DropCircles {

    public static void main(String[] args) {
        new DropCircles();
    }

    public DropCircles() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        protected static final int MAX_CIRCLES = 7;
        private List<Circle> circles;
        private Random rnd = new Random();

        public TestPane() {
            circles = new ArrayList<>(MAX_CIRCLES);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    while (circles.size() < MAX_CIRCLES) {
                        circles.add(createCircle());
                    }

                    List<Circle> purge = new ArrayList<>(MAX_CIRCLES);
                    for (Circle circle : circles) {
                        Point p = circle.getLocation();
                        p.y += circle.getYDelta();
                        if (p.y > getHeight()) {
                            purge.add(circle);
                        } else {
                            circle.setLocation(p);
                        }
                    }
                    circles.removeAll(purge);

                    repaint();
                }
            });
            timer.start();
        }

        protected Circle createCircle() {

            int x = rnd.nextInt(getWidth());
            int radius = 5 + rnd.nextInt(45);
            int speed = 1 + rnd.nextInt(8);

            if (x + radius > getWidth()) {
                x = getWidth() - radius;
            }

            Circle circle = new Circle(radius, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
            circle.setLocation(x, 0);
            circle.setYDelta(speed);

            return circle;

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Circle circle : circles) {
                circle.paint(g);
            }
            g2d.dispose();
        }
    }

    public static class Circle {

        private final int radius;
        private final Color color;
        private int x;
        private int y;

        private int yDelta;

        public Circle(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        public void setLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setLocation(Point p) {
            setLocation(p.x, p.y);
        }

        public Point getLocation() {
            return new Point(x, y);            
        }

        public void setYDelta(int yDelta) {
            this.yDelta = yDelta;
        }

        public int getYDelta() {
            return yDelta;
        }

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, radius, radius);
        }

    }

}