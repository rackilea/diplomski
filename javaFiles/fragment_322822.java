import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleTest2 extends JPanel {
    // avoiding "magic" numbers
    private static final int PREF_W = 500;
    private static final int PREF_H = PREF_W;
    public static final int RECT_X = 200;
    public static final int RECT_Y = RECT_X;
    public static final int RECT_WIDTH = 100;
    public static final int RECT_HEIGHT = 30;

    private double angle;

    private static void createAndShowGui() {
        SimpleTest2 mainPanel = new SimpleTest2();

        JFrame frame = new JFrame("Simple Test 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();  // let the GUI size itself
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    public SimpleTest2() {
        // using an adapter is a nice clean way of avoiding empty method bodies
        MouseAdapter myMouse = new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                calculateAngle(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                calculateAngle(e.getX(), e.getY());
                repaint();
            }

        };
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    public void calculateAngle(int x, int y) {
        // get rid of "magic" numbers
        int deltaX = x - (RECT_X + RECT_WIDTH / 2);// Rectangle Center X
        int deltaY = y - (RECT_Y + RECT_HEIGHT / 2);// Rectangle Center Y
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
    }

    @Override
    public Dimension getPreferredSize() {
        // better way to size the drawing component
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // ***don't forget this guy***
        Graphics2D g2d = (Graphics2D) g;

        // for smoother rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform old = g2d.getTransform();
        g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
        g2d.rotate(Math.toRadians(angle), 250, 215);
        // Rectangle rect2 = new Rectangle(200, 200, 100, 30);
        g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
        g2d.setTransform(old);
    }
}