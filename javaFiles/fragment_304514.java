import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
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

        private double angle;
        private double orbitAngle;
        private int xPos = 0;
        private int size = 20;
        private int outterRadius = size * 2;
        private int delta = 2;

        public TestPane() {
            new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += delta;
                    if (xPos + size >= getWidth()) {
                        xPos = getWidth() - size;
                        delta *= -1;
                    } else if (xPos < 0) {
                        xPos = 0;
                        delta *= -1;
                    }
                    angle += 4;
                    orbitAngle -= 2;
                    repaint();
                }
            }).start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

        protected Point pointOnCircle() {

            double rads = Math.toRadians(orbitAngle - 180); // Make 0 point out to the right...
            int fullLength = Math.round((outterRadius));

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (Math.cos(rads) * fullLength));
            int yPosy = Math.round((float) (Math.sin(rads) * fullLength));

            return new Point(xPosy, yPosy);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int yPos = (getHeight() - size) / 2;
            // Transform the offset
            g2d.transform(AffineTransform.getTranslateInstance(xPos, yPos));

            Graphics2D earthG = (Graphics2D) g2d.create();
            // Rotate around the 0x0 point, this becomes the center point
            earthG.transform(AffineTransform.getRotateInstance(Math.toRadians(angle)));
            // Draw the "earth" around the center point
            earthG.drawRect(-(size / 2), -(size / 2), size, size);
            earthG.dispose();

            // Removes the last transformation
            Graphics2D moonG = (Graphics2D) g2d.create();            
            // Calclate the point on the circle - based on the outterRadius or
            // distance from the center point of the earth
            Point poc = pointOnCircle();
            int moonSize = size / 2;
            // This is only a visial guide used to show the position of the earth
            //moonG.drawOval(-outterRadius, -outterRadius, outterRadius * 2, outterRadius * 2);
            moonG.fillOval(poc.x - (moonSize / 2), poc.y - (moonSize / 2), moonSize, moonSize);
            moonG.dispose();

            g2d.dispose();
        }

    }

}