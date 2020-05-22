import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

/**
 * Left-click to spawn a new background
 * painting task.
 */
class DoubleBuffer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoubleBuffer();
            }
        });
    }

    final int  width = 640;
    final int height = 480;

    BufferedImage createCompatibleImage() {
        GraphicsConfiguration gc =
            GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        // createCompatibleImage creates an image that is
        // optimized for the display device.
        // See http://docs.oracle.com/javase/8/docs/api/java/awt/GraphicsConfiguration.html#createCompatibleImage-int-int-int-
        return gc.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }

    // The front image is the one which is
    // displayed in the panel.
    BufferedImage front = createCompatibleImage();
    // The back image is the one that gets
    // painted to.
    BufferedImage  back = createCompatibleImage();
    boolean  isPainting = false;

    final JFrame frame = new JFrame("Double Buffer");
    final JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Scaling the image to fit the panel.
            Dimension actualSize = getSize();
            int w = actualSize.width;
            int h = actualSize.height;
            g.drawImage(front, 0, 0, w, h, null);
        }
    };

    final MouseAdapter onClick = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (!isPainting) {
                isPainting = true;
                new PaintTask(e.getPoint()).execute();
            }
        }
    };

    DoubleBuffer() {
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(Color.WHITE);
        panel.addMouseListener(onClick);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void swap() {
        BufferedImage temp = front;
        front = back;
        back = temp;
    }

    class PaintTask extends SwingWorker<Void, Void> {
        final Point pt;

        PaintTask(Point pt) {
            this.pt = pt;
        }

        @Override
        public Void doInBackground() {
            Random rand = new Random();

            synchronized(DoubleBuffer.this) {
                Graphics2D g2 = back.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                                    RenderingHints.VALUE_STROKE_PURE);
                g2.setBackground(new Color(0, true));
                g2.clearRect(0, 0, width, height);
                // (This computes pow(2, rand.nextInt(3) + 7).)
                int  depth = 1 << ( rand.nextInt(3) + 7 );
                float  hue = rand.nextInt(depth);
                int radius = 1;
                int c;
                // This loop just draws concentric circles,
                // starting from the inside and extending
                // outwards until it hits the outside of
                // the image.
                do {
                    int rgb = Color.HSBtoRGB(hue / depth, 1, 1);
                    g2.setColor(new Color(rgb));

                    int x = pt.x - radius;
                    int y = pt.y - radius;
                    int d = radius * 2;

                    g2.drawOval(x, y, d, d);

                    ++radius;
                    ++hue;
                    c = (int) (radius * Math.cos(Math.PI / 4));
                } while (
                       (0 <= pt.x - c) || (pt.x + c < width)
                    || (0 <= pt.y - c) || (pt.y + c < height)
                );

                g2.dispose();
                back.flush();

                return (Void) null;
            }
        }

        @Override
        public void done() {
            // done() is completed on the EDT,
            // so for this small program, this
            // is the only place where synchronization
            // is necessary.
            // paintComponent will see the swap
            // happen the next time it is called.
            synchronized(DoubleBuffer.this) {
                swap();
            }

            isPainting = false;
            panel.repaint();
        }
    }
}