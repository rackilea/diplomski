import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class CircleDraw2 extends JPanel {
    private static final int CIRCLE_RADIUS = 25;
    private static final Color BACKGROUND = Color.BLACK;
    private int prefW;
    private int prefH;
    List<Circle2> circles = new ArrayList<>();

    public CircleDraw2(int prefW, int prefH) {
        this.prefW = prefW;
        this.prefH = prefH;
        setBackground(BACKGROUND);
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Circle2 circle : circles) {
            circle.draw(g2);
        }
    }

    private class MyMouse extends MouseAdapter {
        private Point p0 = null;
        private Circle2 selection = null;

        @Override
        public void mousePressed(MouseEvent e) {
            for (int i = circles.size() - 1; i >= 0; i--) {
                if (circles.get(i).contains(e.getPoint())) {
                    // if mouse clicks on a circle that already exists
                    p0 = e.getPoint(); 
                    selection = circles.get(i); // select that pressed circle

                    // move it to the top
                    circles.remove(selection);
                    circles.add(selection);
                    repaint();
                    return;
                }
            }

            // no circle selected, so create a new one
            int centerX = e.getX();
            int centerY = e.getY();
            Color c = createRandomColor();
            selection = new Circle2(centerX, centerY, CIRCLE_RADIUS, c);
            circles.add(selection);
            p0 = e.getPoint();
            repaint();
        }

        private Color createRandomColor() {
            double minRand = 0.7; // min saturation and brightness
            float hue = (float) Math.random();
            float saturation = (float)((1 - minRand) * Math.random() + minRand);
            float brightness = (float)((1 - minRand) * Math.random() + minRand);
            Color c = Color.getHSBColor(hue, saturation, brightness);
            return c;
        }

        private void drag(Point p1) {
            if (p0 == null) {
                return;
            }
            selection.move(p0, p1);
            p0 = p1;
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            drag(e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drag(e.getPoint());
            p0 = null;
            selection = null;
        }
    }

    private static void createAndShowGui() {
        int width = 800;
        int height = width;
        CircleDraw2 mainPanel = new CircleDraw2(width, height);

        JFrame frame = new JFrame("CircleDraw2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}