import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        JPanel circlePanel = new JPanel() {
            @Override
            public void paint(Graphics g) {

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setStroke(new BasicStroke(1));
                //g2d.drawOval(0, 0, 200, 200);
                g2d.draw(new Ellipse2D.Double(0, 0, 200, 200));

                AffineTransform old = g2d.getTransform();

                g2d.scale(10, 10);
                g2d.setStroke(new BasicStroke(1.0f));
                g2d.draw(new Ellipse2D.Double(0, 0, 25.0, 25.0));

                g2d.setTransform(old);

            }
        };

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        circlePanel.setBounds(new Rectangle(0, 0, 300, 300));
        frame.add(circlePanel);

        frame.setBounds(0, 0, 350, 300);

        //frame.pack();
        frame.setVisible(true);
    }
}