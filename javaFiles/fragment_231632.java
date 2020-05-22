import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**
 * Holding left-click draws, and
 * right-clicking cycles the color.
 */
class PaintAnyTime {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintAnyTime();
            }
        });
    }

    Color[]    colors = {Color.red, Color.blue, Color.black};
    int  currentColor = 0;
    BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
    Graphics2D  imgG2 = img.createGraphics();

    JFrame frame = new JFrame("Paint Any Time");
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Creating a copy of the Graphics
            // so any reconfiguration we do on
            // it doesn't interfere with what
            // Swing is doing.
            Graphics2D g2 = (Graphics2D) g.create();
            // Drawing the image.
            int w = img.getWidth();
            int h = img.getHeight();
            g2.drawImage(img, 0, 0, w, h, null);
            // Drawing a swatch.
            Color color = colors[currentColor];
            g2.setColor(color);
            g2.fillRect(0, 0, 16, 16);
            g2.setColor(Color.black);
            g2.drawRect(-1, -1, 17, 17);
            // At the end, we dispose the
            // Graphics copy we've created
            g2.dispose();
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    };

    MouseAdapter drawer = new MouseAdapter() {
        boolean rButtonDown;
        Point prev;

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                prev = e.getPoint();
            }
            if (SwingUtilities.isRightMouseButton(e) && !rButtonDown) {
                // (This just behaves a little better
                // than using the mouseClicked event.)
                rButtonDown  = true;
                currentColor = (currentColor + 1) % colors.length;
                panel.repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (prev != null) {
                Point  next = e.getPoint();
                Color color = colors[currentColor];
                // We can safely paint to the
                // image any time we want to.
                imgG2.setColor(color);
                imgG2.drawLine(prev.x, prev.y, next.x, next.y);
                // We just need to repaint the
                // panel to make sure the
                // changes are visible
                // immediately.
                panel.repaint();
                prev = next;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                prev = null;
            }
            if (SwingUtilities.isRightMouseButton(e)) {
                rButtonDown = false;
            }
        }
    };

    PaintAnyTime() {
        // RenderingHints let you specify
        // options such as antialiasing.
        imgG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        imgG2.setStroke(new BasicStroke(3));
        //
        panel.setBackground(Color.white);
        panel.addMouseListener(drawer);
        panel.addMouseMotionListener(drawer);
        Cursor cursor =
            Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
        panel.setCursor(cursor);
        frame.setContentPane(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}