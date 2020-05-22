import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PreviewDesktop {

    public static void main(String[] args) {
        new PreviewDesktop();
    }

    public PreviewDesktop() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements Puzzler {

        private Rectangle virtualBounds;
        private double scale;

        private Map<Integer, PuzzlePiece> pieces;

        public TestPane() {
            virtualBounds = getVirtualBounds();
            int columns = 4;
            int rows = 4;
            pieces = new HashMap<>(columns * rows);

            int columnWidth = Math.round(virtualBounds.width / (float) columns);
            int rowHeight = Math.round(virtualBounds.height / (float) rows);

            int id = 0;
            for (int row = 0; row < rows; row++) {
                int y = virtualBounds.y + (row * rowHeight);
                for (int column = 0; column < columns; column++) {
                    int x = virtualBounds.x + (column * columnWidth);
                    Rectangle bounds = new Rectangle(x, y, columnWidth, rowHeight);
                    GrabberWorker worker = new GrabberWorker(id, this, bounds);
                    System.out.println(id);
                    id++;
                    startThread(worker);
                }
            }
        }

        @Override
        public double getScale() {
            return scale;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            scale = getScaleFactorToFit(virtualBounds.getSize(), getSize());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (Integer id : pieces.keySet()) {
                PuzzlePiece piece = pieces.get(id);
                Rectangle bounds = piece.getBounds();
                BufferedImage img = piece.getImage();
                g2d.drawImage(img, bounds.x, bounds.y, this);
                // If you want to see each sections bounds, uncomment below...
                //g2d.draw(bounds);
            }
            g2d.dispose();
        }

        @Override
        public void setPiece(int id, PuzzlePiece piece) {
            pieces.put(id, piece);
            repaint();
        }

        protected void startThread(GrabberWorker worker) {
            Thread thread = new Thread(worker);
            thread.setDaemon(true);
            thread.start();
        }
    }

    public class PuzzlePiece {

        private final Rectangle bounds;
        private final BufferedImage img;

        public PuzzlePiece(Rectangle bounds, BufferedImage img) {
            this.bounds = bounds;
            this.img = img;
        }

        public Rectangle getBounds() {
            return bounds;
        }

        public BufferedImage getImage() {
            return img;
        }

    }

    public interface Puzzler {

        public void setPiece(int id, PuzzlePiece piece);

        public double getScale();

    }

    public class GrabberWorker implements Runnable {

        private Rectangle bounds;
        private Puzzler puzzler;
        private int id;

        private volatile PuzzlePiece parked;
        private ReentrantLock lckParked;

        public GrabberWorker(int id, Puzzler puzzler, Rectangle bounds) {
            this.id = id;
            this.bounds = bounds;
            this.puzzler = puzzler;
            lckParked = new ReentrantLock();
        }

        protected void process(PuzzlePiece piece) {
//            puzzler.setPiece(bounds, chunks.get(chunks.size() - 1));

            puzzler.setPiece(id, piece);
        }

        protected void publish(PuzzlePiece piece) {

            lckParked.lock();
            try {
                parked = piece;
            } finally {
                lckParked.unlock();
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    lckParked.lock();
                    try {
                        process(parked);
                    } finally {
                        lckParked.unlock();
                    }
                }
            });

        }

        @Override
        public void run() {
            try {
                Robot bot = new Robot();
                while (true) {
                    BufferedImage img = bot.createScreenCapture(bounds);

                    double scale = puzzler.getScale();
                    Rectangle scaled = new Rectangle(bounds);
                    scaled.x *= scale;
                    scaled.y *= scale;
                    scaled.width *= scale;
                    scaled.height *= scale;

                    BufferedImage imgScaled = getScaledInstance(img, scale);

                    publish(new PuzzlePiece(scaled, imgScaled));

                    Thread.sleep(500);

                }
            } catch (AWTException | InterruptedException exp) {
                exp.printStackTrace();
            }
        }

    }

    public static Rectangle getVirtualBounds() {

        Rectangle bounds = new Rectangle(0, 0, 0, 0);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {

            bounds.add(gd.getDefaultConfiguration().getBounds());

        }

        return bounds;

    }

    public static double getScaleFactorToFit(Dimension original, Dimension toFit) {

        double dScale = 1d;

        if (original != null && toFit != null) {

            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);

            dScale = Math.min(dScaleHeight, dScaleWidth);

        }

        return dScale;

    }

    public static double getScaleFactor(int iMasterSize, int iTargetSize) {

        double dScale = (double) iTargetSize / (double) iMasterSize;
        return dScale;

    }

    public static BufferedImage getScaledInstance(BufferedImage img, double dScaleFactor) {

        return getScaledInstance(img, dScaleFactor, RenderingHints.VALUE_INTERPOLATION_BILINEAR, true);

    }

    protected static BufferedImage getScaledInstance(BufferedImage img, double dScaleFactor, Object hint, boolean bHighQuality) {

        BufferedImage imgScale = img;

        int iImageWidth = (int) Math.round(img.getWidth() * dScaleFactor);
        int iImageHeight = (int) Math.round(img.getHeight() * dScaleFactor);

//        System.out.println("Scale Size = " + iImageWidth + "x" + iImageHeight);
        if (dScaleFactor <= 1.0d) {

            imgScale = getScaledDownInstance(img, iImageWidth, iImageHeight, hint, bHighQuality);

        } else {

            imgScale = getScaledUpInstance(img, iImageWidth, iImageHeight, hint, bHighQuality);

        }

        return imgScale;

    }

    protected static BufferedImage getScaledDownInstance(BufferedImage img,
            int targetWidth,
            int targetHeight,
            Object hint,
            boolean higherQuality) {

        int type = (img.getTransparency() == Transparency.OPAQUE)
                ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;

        BufferedImage ret = (BufferedImage) img;
        if (targetHeight > 0 || targetWidth > 0) {
            int w, h;
            if (higherQuality) {
                // Use multi-step technique: start with original size, then
                // scale down in multiple passes with drawImage()
                // until the target size is reached
                w = img.getWidth();
                h = img.getHeight();
            } else {
                // Use one-step technique: scale directly from original
                // size to target size with a single drawImage() call
                w = targetWidth;
                h = targetHeight;
            }

            do {
                if (higherQuality && w > targetWidth) {
                    w /= 2;
                    if (w < targetWidth) {
                        w = targetWidth;
                    }
                }

                if (higherQuality && h > targetHeight) {
                    h /= 2;
                    if (h < targetHeight) {
                        h = targetHeight;
                    }
                }

                BufferedImage tmp = new BufferedImage(Math.max(w, 1), Math.max(h, 1), type);
                Graphics2D g2 = tmp.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
                g2.drawImage(ret, 0, 0, w, h, null);
                g2.dispose();

                ret = tmp;
            } while (w != targetWidth || h != targetHeight);
        } else {
            ret = new BufferedImage(1, 1, type);
        }
        return ret;
    }

    protected static BufferedImage getScaledUpInstance(BufferedImage img,
            int targetWidth,
            int targetHeight,
            Object hint,
            boolean higherQuality) {

        int type = BufferedImage.TYPE_INT_ARGB;

        BufferedImage ret = (BufferedImage) img;
        int w, h;
        if (higherQuality) {
            w = img.getWidth();
            h = img.getHeight();
        } else {
            w = targetWidth;
            h = targetHeight;
        }

        do {
            if (higherQuality && w < targetWidth) {
                w *= 2;
                if (w > targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h < targetHeight) {
                h *= 2;
                if (h > targetHeight) {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
            tmp = null;
        } while (w != targetWidth || h != targetHeight);
        return ret;
    }
}