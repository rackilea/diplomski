import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private GeneralPath gp = new GeneralPath();
        private double spinValue = 0;

        public TestPane() {
            gp.append(new Ellipse2D.Double(0, 0, 200, 200), true);

            for (double angle = 0; angle < 360; angle += 30) {
                Arc2D arc = new Arc2D.Double(0, 0, 200, 200,
                        angle,
                        30,
                        Arc2D.PIE);
                gp.append(arc, false);
            }

            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spinValue += 0.01;
                    repaint();
                }
            });
            timer.start();
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

            Rectangle2D bounds = gp.getBounds2D();
            double x = (getWidth() - bounds.getWidth()) / 2d;
            double y = (getHeight() - bounds.getHeight()) / 2d;

            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            at.rotate(spinValue, bounds.getCenterX(), bounds.getCenterY());

            g2d.transform(at);
            g2d.draw(gp);
            g2d.dispose();
        }
    }

}