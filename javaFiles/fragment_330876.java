import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        public TestPane() {
            setLayout(new BorderLayout());

            DrawPane drawPane = new DrawPane();
            add(drawPane);

            JSlider slider = new JSlider(0, 100);
            add(slider, BorderLayout.SOUTH);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    drawPane.setAngleInDegrees(360d * (slider.getValue() / 100d));
                }
            });
            slider.setValue(0);
        }

    }

    public class DrawPane extends JPanel {

        private double angle;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Radius of the circle
            double r = 150;
            // Degrees to radians...
            double radians = Math.toRadians(angle);

            // The end point on the circle...
            int endX = (int) Math.round(r * Math.cos(radians));
            int endY = (int) Math.round(r * Math.sin(radians));

                        // The start point on the circle, 360 degress from the
            // start angle
            radians = Math.toRadians(angle - 360);
            int startX = (int) Math.round(r * Math.cos(radians));
            int startY = (int) Math.round(r * Math.sin(radians));

            // Offset for the ellipse (center of the screen)
            double x = (getWidth() / 2d) - r;
            double y = (getWidth() / 2d) - r;

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.draw(new Ellipse2D.Double(x, y, r * 2, r * 2));
            // Center of the circle...
            x = (getWidth() / 2d);
            y = (getWidth() / 2d);

            // One single line
            //g2d.setColor(Color.BLACK);
            //g2d.draw(new Line2D.Double(x - startX, y - startY, x + endX, y + endY));

            g2d.setColor(Color.RED);
            g2d.draw(new Line2D.Double(x, y, x - startX, y - startY));
            g2d.setColor(Color.BLUE);
            g2d.draw(new Line2D.Double(x, y, x + endX, y + endY));

            g2d.dispose();
        }

        public void setAngleInDegrees(double value) {
            if (angle != value) {
                angle = Math.min(Math.max(value, 0), 360);
                repaint();
            }
        }

    }

}