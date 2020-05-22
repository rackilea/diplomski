import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;

import javax.swing.*;

public class Test extends JPanel {
    private static final int PREF_W = 850;
    private static final int PREF_H = PREF_W;
    Rectangle2D rectangle1 = new Rectangle2D.Double(32, 64, 32, 32);     
    // Rectangle2D rectangle2 = new Rectangle2D.Double(0, 32, 32, 32);      

    Line2D line = new Line2D.Double(36, 63, 5, 12);

    public Test() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        double scale = 8.0;
        g2.scale(scale, scale); // make it big to show it for you
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(rectangle1);
        // g2.draw(rectangle2);
        g2.draw(line);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        Test mainPanel = new Test();

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}