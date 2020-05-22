import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(new TestPane()));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements Scrollable {

        private BufferedImage master;
        private Image scaled;
        private double zoom = 1d;
        private ExecutorService service;
        private List<Future> scaleTasks;
        private final Timer zoomTimer;

        public TestPane() {
            scaleTasks = new ArrayList<>(5);
            service = Executors.newSingleThreadExecutor();
            try {
                master = ImageIO.read(new File("Some image some where"));
                scaled = master;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            zoomTimer = new Timer(125, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Update Zoom to " + getZoom());
                    updateToZoomFactor(getZoom());
                }
            });
            zoomTimer.setRepeats(false);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "plus");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "minus");

            am.put("plus", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double zoom = getZoom() + 0.1;
                    setZoom(zoom);
                }
            });
            am.put("minus", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double zoom = getZoom() - 0.1;
                    setZoom(zoom);
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return scaled == null
                            ? new Dimension(master.getWidth(), master.getHeight())
                            : new Dimension(scaled.getWidth(this), scaled.getHeight(this));
        }

        public BufferedImage getMaster() {
            return master;
        }

        public void setZoom(double value) {
            if (value < 0.1) {
                value = 0.1;
            } else if (value > 2) {
                value = 2d;
            }
            if (value != zoom) {
                zoom = value;
                zoomTimer.restart();
            }
        }

        public double getZoom() {
            return zoom;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (scaled != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - scaled.getWidth(this)) / 2;
                int y = (getHeight() - scaled.getHeight(this)) / 2;
                g2d.drawImage(scaled, x, y, this);
                g2d.dispose();
            }
        }

        protected void setScaledResult(final Image image) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    scaled = image;
                    invalidate();
                    revalidate();
                    repaint();
                }
            });
        }

        protected void updateToZoomFactor(double zoom) {
            Future[] tasks = scaleTasks.toArray(new Future[scaleTasks.size()]);
            for (Future task : tasks) {
                if (!task.isCancelled()) {
                    task.cancel(true);
                } else {
                    scaleTasks.remove(task);
                }
            }
            service.submit(new RescaleTask(zoom));
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(400, 400);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

        protected class RescaleTask implements Callable<Image> {

            private double zoom;

            protected RescaleTask(double zoom) {
                this.zoom = zoom;
            }

            @Override
            public Image call() throws Exception {
                if (zoom == 1) {
                    scaled = getMaster();
                } else {
                    int width = (int) (getMaster().getWidth() * zoom);
                    int height = (int) (getMaster().getHeight() * zoom);
                    Image scaled = getMaster().getScaledInstance((int) width, (int) height, Image.SCALE_FAST);
                    if (!Thread.currentThread().isInterrupted()) {
                        setScaledResult(scaled);

                        if (zoom < 1) {
                            scaled = getScaledDownInstance(getMaster(), (int) width, (int) height);
                        } else {
                            scaled = getScaledUpInstance(getMaster(), (int) width, (int) height);
                        }

                        if (!Thread.currentThread().isInterrupted()) {
                            setScaledResult(scaled);
                        } else {
                            System.out.println("Was interrupted during quality scale");
                        }

                    } else {
                        System.out.println("Was interrupted during fast scale");
                    }
                }
                return scaled;
            }

            protected BufferedImage getScaledDownInstance(BufferedImage img,
                            int targetWidth,
                            int targetHeight) {

                int type = (img.getTransparency() == Transparency.OPAQUE)
                                ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;

                BufferedImage ret = (BufferedImage) img;

                if (targetHeight > 0 || targetWidth > 0) {

                    int w = img.getWidth();
                    int h = img.getHeight();

                    do {

                        System.out.println(w + "x" + h + " -> " + targetWidth + "x" + targetHeight);

                        if (w > targetWidth) {
                            w /= 2;
                            if (w < targetWidth) {
                                w = targetWidth;
                            }
                        }

                        if (h > targetHeight) {
                            h /= 2;
                            if (h < targetHeight) {
                                h = targetHeight;
                            }
                        }

                        BufferedImage tmp = new BufferedImage(Math.max(w, 1), Math.max(h, 1), type);
                        Graphics2D g2 = tmp.createGraphics();
                        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        g2.drawImage(ret, 0, 0, w, h, null);
                        g2.dispose();

                        ret = tmp;

                    } while (w != targetWidth || h != targetHeight);

                } else {

                    ret = new BufferedImage(1, 1, type);

                }

                return ret;

            }

            protected BufferedImage getScaledUpInstance(BufferedImage img,
                            int targetWidth,
                            int targetHeight) {

                int type = BufferedImage.TYPE_INT_ARGB;

                BufferedImage ret = (BufferedImage) img;
                int w = img.getWidth();
                int h = img.getHeight();

                do {

                    if (w < targetWidth) {
                        w *= 2;
                        if (w > targetWidth) {
                            w = targetWidth;
                        }
                    }

                    if (h < targetHeight) {
                        h *= 2;
                        if (h > targetHeight) {
                            h = targetHeight;
                        }
                    }

//          createCompatibleImage(w, h, type)
                    BufferedImage tmp = new BufferedImage(w, h, type);
                    Graphics2D g2 = tmp.createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2.drawImage(ret, 0, 0, w, h, null);
                    g2.dispose();

                    ret = tmp;
                    tmp = null;

                } while (w != targetWidth || h != targetHeight);

                return ret;

            }

        }

    }

}