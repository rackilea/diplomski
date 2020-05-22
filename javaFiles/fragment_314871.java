import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private GeneralPath gp = new GeneralPath();

        public TestPane() {

            //GeneralPath gp = new GeneralPath();
            gp.append(new Ellipse2D.Double(0, 0, 200, 200), true);

            for (double angle = 0; angle < 180; angle += 30) {
                Point2D startPoint = pointOnCircle(angle, 100);
                Point2D endPoint = pointOnCircle(angle + 180, 100);

                gp.moveTo(startPoint.getX(), startPoint.getY());
                gp.lineTo(endPoint.getX(), endPoint.getY());
            }

        }

        protected Point2D pointOnCircle(double degrees, double radius) {
            double origin = radius;
            double rads = Math.toRadians(degrees);
            double x = origin + (Math.cos(rads) * radius);
            double y = origin + (Math.sin(rads) * radius);

            return new Point2D.Double(x, y);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(hints);
            g2d.translate(50, 50);
            g2d.draw(gp);
            g2d.dispose();
        }
    }

}