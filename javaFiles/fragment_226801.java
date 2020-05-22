import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class FlipUpsideDown {

    public static void main(String[] args) {
        JTextArea textArea = new JTextArea("This is a working text area\n\nI LOVE SWING", 4, 0);
        // The cursor still use the wrong mouse position so...
        textArea.setCursor(Cursor.getDefaultCursor());

        final JPanel mainPanel = new JPanel(new BorderLayout(5, 5));

        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.add(new JLabel("A Normal Label"), BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(new JButton("Hello World!"), BorderLayout.SOUTH);

        // The root pane is responsible for drawing all the children of the 
        // frame. All the paint calls go through the root pane since dirty
        // painting of individual controls are blocked (see below). So we can 
        // use the paint method of the root pane to flip the painted controls.
        final JFrame f = new JFrame("FlipUpsideDown") {

            protected JRootPane createRootPane() {
                JRootPane rp = new JRootPane() {

                    public void paint(Graphics g) {
                        BufferedImage im = new BufferedImage(this.getWidth(), this.getHeight(),
                                BufferedImage.TYPE_3BYTE_BGR);
                        // Paint normally but on the image
                        super.paint(im.getGraphics());

                        // Reverse the image
                        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
                        tx.translate(0, -im.getHeight());
                        AffineTransformOp op = new AffineTransformOp(tx,
                                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                        im = op.filter(im, null);

                        // Draw the reversed image on the screen
                        g.drawImage(im, 0, 0, null);
                    }
                };
                rp.setOpaque(true);
                return rp;
            }
        };

        // Override the RepaintManager so that we always repaint the entire 
        // frame when a region is set to dirty.
        RepaintManager repaintManager = new RepaintManager() {

            public void addDirtyRegion(JComponent c, int x, int y, int w, int h) {
                schedulePaint();
            }

            public void addDirtyRegion(Window window, int x, int y, int w, int h) {
                schedulePaint();
            }

            public void paintDirtyRegions() {
                schedulePaint();
            }

            private void schedulePaint() {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        f.paint(f.getGraphics());
                    }
                });
            }
        };
        RepaintManager.setCurrentManager(repaintManager);

        // Intercept mouse events and flip their positions around in the JFrame
        EventQueue queue = new EventQueue() {

            protected void dispatchEvent(AWTEvent event) {
                if (event instanceof MouseEvent) {
                    MouseEvent me = (MouseEvent) event;
                    MouseEvent evt = new MouseEvent(
                            me.getComponent(),
                            me.getID(),
                            me.getWhen(),
                            me.getModifiers(),
                            f.getWidth() - me.getX() + f.getInsets().right - f.getInsets().left,
                            f.getHeight() - me.getY() + f.getInsets().top - f.getInsets().bottom,
                            me.getClickCount(),
                            false,
                            me.getButton());
                    event = evt;
                }
                super.dispatchEvent(event);
            }
        };
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(queue);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.add(mainPanel);
        f.pack();
        f.setVisible(true);
    }
}