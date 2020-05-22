import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class ZoomPanel extends JPanel {

    private static final int STEP = 40;
    private int iter = 0;
    private long cumulativeTimeTaken = 0;


    public static void main(String[] args) {
        final JFrame frame = new JFrame("Image zoom");

        final ZoomPanel zoomPanel = new ZoomPanel();
        frame.getContentPane().add(zoomPanel);
        final Ticker t = new Ticker(zoomPanel);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                t.done();
                frame.dispose();
            }
        });
        t.start();

        frame.setLocation(new Point(640, 0));
        frame.pack();
        frame.setVisible(true);
    }

    private final Color[][] model = new Color[8][8];

    public ZoomPanel() {
        setSize(new Dimension(400, 400));
        setMinimumSize(new Dimension(400, 400));
        setPreferredSize(new Dimension(400, 400));
        setOpaque(true);
    }

    private void setColorAt(int x, int y, Color pixelColor) {
        model[x][y] = pixelColor;
        repaint(40 + x * STEP, 45 + y * STEP, 40 + (x * STEP) - 3, 45 + (y * STEP) - 3);
    }

    private Color getColorAt(int x, int y) {
        return model[x][y];
    }

    public void paintComponent(Graphics g) {
        long start = System.currentTimeMillis();
        if (!SwingUtilities.isEventDispatchThread()) {
            throw new RuntimeException("Repaint attempt is not on event dispatch thread");
        }
        final Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        try {

            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    g2.setColor(model[x][y]);
                    Ellipse2D e = new Ellipse2D.Double(40 + x * STEP, 45 + y * STEP, STEP - 3, STEP - 3);
                    g2.fill(e);
                    g2.setColor(Color.GRAY);
                    g2.draw(e);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        iter++;
        g2.setColor(Color.black);
        long stop = System.currentTimeMillis();
        cumulativeTimeTaken += stop - start;
        StringBuilder sb = new StringBuilder();
        sb.append(iter)
                .append(" frames in ")
                .append((double) (cumulativeTimeTaken) / 1000)
                .append("s.");

        System.out.println(sb);
    }

    private static class Ticker extends Thread {

        private final Robot robot;

        public boolean update = true;
        private final ZoomPanel view;

        public Ticker(ZoomPanel zoomPanel) {
            view = zoomPanel;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }

        public void done() {
            update = false;
        }

        public void run() {
            int runCount = 0;
            while (update) {
                runCount++;
                if (runCount % 100 == 0) {
                    System.out.println("Ran ticker " + runCount + " times");
                }
                final Point p = MouseInfo.getPointerInfo().getLocation();

                Rectangle rect = new Rectangle(p.x - 4, p.y - 4, 8, 8);
                final BufferedImage capture = robot.createScreenCapture(rect);

                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        final Color pixelColor = new Color(capture.getRGB(x, y));

                        if (!pixelColor.equals(view.getColorAt(x, y))) {
                            final int finalX = x;
                            final int finalY = y;
                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    view.setColorAt(finalX, finalY, pixelColor);
                                }
                            });
                        }
                    }
                }

            }
        }

    }

}