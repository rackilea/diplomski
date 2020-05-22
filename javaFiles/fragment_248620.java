import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DividedSquare {

    public static void main(String[] args) {
        new DividedSquare();
    }

    public DividedSquare() {
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

        private TriangleShape baseTriangle;
        private Color[] colors;

        public TestPane() {
            colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA};
        }

        @Override
        public void invalidate() {
            super.invalidate();

            baseTriangle = new TriangleShape(
                    new Point(0, 0),
                    new Point(getWidth(), 0),
                    new Point(getWidth() / 2, getHeight() / 2));

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            String text[] = new String[]{
                "123.123",
                "456.789",
                "012.315",
                "678.921"
            };

            FontMetrics fm = g2d.getFontMetrics();

            double angel = 0;
            for (int index = 0; index < 4; index++) {
                g2d.setColor(colors[index]);
                Path2D rotated = rotate(baseTriangle, angel);
                g2d.fill(rotated);
                Rectangle bounds = rotated.getBounds();
                int x = bounds.x + ((bounds.width - fm.stringWidth(text[0])) / 2);
                int y = bounds.y + (((bounds.height - fm.getHeight()) / 2) + fm.getAscent());
                g2d.setColor(Color.WHITE);
                g2d.drawString(text[index], x, y);
                angel += 90;
            }
            g2d.setColor(Color.BLACK);
            g2d.drawLine(0, 0, getWidth(), getHeight());
            g2d.drawLine(getWidth(), 0, 0, getHeight());
            g2d.dispose();
        }

        public Path2D rotate(TriangleShape shape, double angel) {

            Rectangle bounds = shape.getBounds();
            int x = bounds.width / 2;
            int y = bounds.width / 2;

            return new Path2D.Float(shape, AffineTransform.getRotateInstance(
                    Math.toRadians(angel),
                    x,
                    y));

        }

    }

    public class TriangleShape extends Path2D.Double {

        public TriangleShape(Point2D... points) {
            moveTo(points[0].getX(), points[0].getY());
            lineTo(points[1].getX(), points[1].getY());
            lineTo(points[2].getX(), points[2].getY());
            closePath();
        }

    }
}