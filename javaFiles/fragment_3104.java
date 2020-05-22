import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test2 {

    public static void main(String[] args) {
        new Test2();
    }

    public Test2() {
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

        private Point centerPoint;
        private Shape circle;

        public TestPane() {
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (centerPoint == null) {
                        centerPoint = e.getPoint();
                        repaint();
                    } else {
                        double xTop = Math.min(e.getPoint().x, centerPoint.x);
                        double yTop = Math.min(e.getPoint().y, centerPoint.y);
                        double xBottom = Math.max(e.getPoint().x, centerPoint.x);
                        double yBottom = Math.max(e.getPoint().y, centerPoint.y);

                        double radius = Math.max(xBottom - xTop, yBottom - yTop);
                        xTop = centerPoint.x - radius;
                        yTop = centerPoint.y - radius;

                        radius *= 2;

                        circle = new Ellipse2D.Double(xTop, yTop, radius, radius);
                        repaint();
                    }
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (circle != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.draw(circle);
                g2d.dispose();
            }
        }

    }

}