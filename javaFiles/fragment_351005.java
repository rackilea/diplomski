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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Spacy {

    public static void main(String[] args) {
        new Spacy();
    }

    public Spacy() {
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

    public class TestPane extends JPanel {

        private List<Movable> movables;

        public TestPane() {
            movables = new ArrayList<>(25);
            movables.add(new SpaceObject());

            Timer timer;
            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Movable m : movables) {
                        m.move(getSize());
                    }
                    repaint();
                }
            });
            timer.start();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Paintable p : movables) {
                p.paint(g);
            }
            g2d.dispose();
        }
    }

    public interface Paintable {

        public void paint(Graphics g);

    }

    public interface Movable extends Paintable {

        public void setLocation(Point p);
        public Point getLocation();
        public void move(Dimension size);

    }

    public class SpaceObject implements Movable {

        private Point p;

        public SpaceObject() {
            setLocation(new Point(150, 50));
        }

        @Override
        public void setLocation(Point p) {
            this.p = p;
        }

        @Override
        public Point getLocation() {
            return p;
        }

        @Override
        public void paint(Graphics g) {

            g.setColor(Color.RED);
            Point p = getLocation();
            int radius = 10;
            g.fillOval(p.x - (radius / 2), p.y - (radius / 2), radius, radius);

        }

        @Override
        public void move(Dimension size) {
            Point p = getLocation();
            int delatX = 0;
            int delatY = 0;
            int gap = size.height / 4;
            if (p.y == gap) {
                delatX = 2;
            } else if (p.y == size.height - gap) {
                delatX = -2;
            }
            gap = size.width / 4;
            if (p.x == gap) {
                delatY = -2;
            } else if (p.x == size.width - gap) {
                delatY = 2;
            }
            p.x += delatX;
            p.y += delatY;

            if (p.x < (size.width / 4)) {
                p.x = size.width / 4;
            } else if (p.x > (size.width - (size.width / 4))) {
                p.x = size.width - (size.width / 4);
            }
            if (p.y < (size.height / 4)) {
                p.y = size.height / 4;
            } else if (p.y > (size.height - (size.height / 4))) {
                p.y = size.height - (size.height / 4);
            }

            setLocation(p);
        }            
    }        
}