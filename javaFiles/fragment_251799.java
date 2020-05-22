import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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

        protected static final int DEFAULT_WIDTH = 200;
        protected static final int DEFAULT_HEIGHT = 200;

        private Dimension preferredSize = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        private JLabel properties;
        private boolean highlighted = false;

        private Rectangle hoverRect = new Rectangle(10, 10, 50, 50);

        public TestPane() {
            setLayout(new GridBagLayout());
            properties = new JLabel("...");
            add(properties);

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();

                    Point world = toWorld(e.getPoint());

                    highlighted = hoverRect.contains(world);
                    repaint();

                    properties.setText("<html>@" + format(e.getPoint())
                            + "<br>world = " + format(world)
                            + "<br>view = " + format(toView(world)));
                }

            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    preferredSize = new Dimension(DEFAULT_WIDTH * 2, DEFAULT_HEIGHT * 2);
                    SwingUtilities.windowForComponent(TestPane.this).pack();
                }
            });
        }

        protected String format(Point p) {
            return p.x + "x" + p.y;
        }

        protected Point toView(int x, int y) {
            return toView(new Point(x, y));
        }

        protected Point toView(Point p) {
            Point scaled = new Point(p);
            scaled.x = Math.round(p.x * ((float) getWidth() / (float) DEFAULT_WIDTH));
            scaled.y = Math.round(p.y * ((float) getHeight() / (float) DEFAULT_HEIGHT));
            return scaled;
        }

        protected Point toWorld(int x, int y) {
            return toWorld(new Point(x, y));
        }

        protected Point toWorld(Point p) {
            Point scaled = new Point(p);
            scaled.x = Math.round(p.x * ((float) DEFAULT_WIDTH) / (float) getWidth());
            scaled.y = Math.round(p.y * ((float) DEFAULT_HEIGHT) / (float) getHeight());
            return scaled;
        }

        protected Rectangle toWorld(Rectangle bounds) {
            return toWorld(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        protected Rectangle toWorld(int x, int y, int width, int height) {
            Rectangle scaled = new Rectangle();
            scaled.setLocation(toWorld(x, y));
            scaled.width = Math.round(width * ((float) DEFAULT_WIDTH / (float) getWidth()));
            scaled.height = Math.round(height * ((float) DEFAULT_HEIGHT / (float) getHeight()));
            return scaled;
        }

        protected Rectangle toView(Rectangle bounds) {
            return toView(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        protected Rectangle toView(int x, int y, int width, int height) {
            Rectangle scaled = new Rectangle();
            scaled.setLocation(toView(x, y));
            scaled.width = Math.round(width * ((float) getWidth() / (float) DEFAULT_WIDTH));
            scaled.height = Math.round(height * ((float) getHeight() / (float) DEFAULT_HEIGHT));
            return scaled;
        }

        @Override
        public Dimension getPreferredSize() {
            return preferredSize;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Rectangle bounds = toView(hoverRect);
            if (highlighted) {
                g2d.setColor(Color.BLUE);
                g2d.fill(bounds);
            }
            g2d.setColor(Color.BLACK);
            g2d.draw(bounds);
        }

    }

}