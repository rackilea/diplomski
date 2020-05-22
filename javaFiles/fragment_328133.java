import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BresenhamBlocky {

    static class TestPanel extends JPanel {
        public TestPanel() {
            setPreferredSize(new Dimension(800, 800));
        }

        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, w, h);
            g.setColor(Color.BLUE);
            drawLine(g, w >> 1, h >> 1, targetX, targetY, 10);
        }
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> { showTest(); });
    }

    static int targetX, targetY;

    static void showTest() {
        JFrame frame = new JFrame("Test");
        JComponent test = new TestPanel();
        test.setFocusable(true);
        test.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                targetX = e.getX();
                targetY = e.getY();
                e.getComponent().repaint();
            }
        });
        frame.setLayout(new BorderLayout());
        frame.add(test, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void drawLine(Graphics g, int x0, int y0, int x1, int y1, int blockSize) {
        int scaledX0 = x0 / blockSize;
        int scaledY0 = y0 / blockSize;
        int scaledX1 = x1 / blockSize;
        int scaledY1 = y1 / blockSize;
        int dx = scaledX1 - scaledX0;
        int dy = scaledY1 - scaledY0;
        int stepX = Integer.signum(dx);
        int stepY = Integer.signum(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        int dx2 = dx << 1;
        int dy2 = dy << 1;
        int x = scaledX0;
        int y = scaledY0;
        int error;
        if (dx >= dy) {
            error = dy2 - dx;
            do {
                plot(g, x, y, blockSize);
                if (error > 0) {
                    y += stepY;
                    error -= dx2;
                }
                error += dy2;
                x += stepX;
            } while (x != scaledX1);
        } else {
            error = dx2 - dy;
            do {
                plot(g, x, y, blockSize);
                if (error > 0) {
                    x += stepX;
                    error -= dy2;
                }
                error += dx2;
                y += stepY;
            } while (y != scaledY1);
        }
    }

    static void plot(Graphics g, int x, int y, int blockSize) {
        int x0 = x * blockSize;
        int y0 = y * blockSize;
        int w = blockSize;
        int h = blockSize;
        g.fillRect(x0, y0, w, h);
    }

}