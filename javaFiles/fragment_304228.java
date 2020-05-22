import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JavaApplication124 {

    public static void main(String[] args) {
        new JavaApplication124();
    }

    public JavaApplication124() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Point source;
        private Shape sourceShape;
        private List<Ping> pings;
        private List<Shape> destinations;

        private Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};

        private AnimationEngine engine;

        public TestPane() {
            source = new Point(10, 10);
            sourceShape = new Ellipse2D.Double(source.x - 5, source.y - 5, 10, 10);

            Dimension size = getPreferredSize();

            Random rnd = new Random();
            int quantity = 1 + rnd.nextInt(10);
            pings = new ArrayList<>(quantity);
            destinations = new ArrayList<>(quantity);
            for (int index = 0; index < quantity; index++) {
                int x = 20 + rnd.nextInt(size.width - 25);
                int y = 20 + rnd.nextInt(size.height - 25);

                Point toPoint = new Point(x, y);

                // Create the "ping"
                Color color = colors[rnd.nextInt(colors.length)];
                Ping ping = new Ping(source, toPoint, color);
                pings.add(ping);

                // Create the destination shape...
                Rectangle bounds = ping.getBounds();
                Shape destination = new Ellipse2D.Double(toPoint.x - (bounds.width / 2d), toPoint.y - (bounds.height / 2d), 10, 10);
                destinations.add(destination);
            }

            engine = new AnimationEngine(Duration.ofSeconds(10));
            engine.setListener(new AnimationEngine.AnimationEngineListener() {
                @Override
                public void animationEngineTicked(AnimationEngine source, double progress) {
                    for (Ping ping : pings) {
                        ping.update(progress);
                    }
                    repaint();
                }
            });
            engine.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // This is probably overkill, but it will make the output look nicer ;)
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

            // Lines first, these could be cached
            g2d.setColor(Color.LIGHT_GRAY);
            double fromX = sourceShape.getBounds2D().getCenterX();
            double fromY = sourceShape.getBounds2D().getCenterY();
            for (Shape destination : destinations) {
                double toX = destination.getBounds2D().getCenterX();
                double toY = destination.getBounds2D().getCenterY();
                g2d.draw(new Line2D.Double(fromX, fromY, toX, toY));
            }

            // Pings, so they appear above the line, but under the points
            for (Ping ping : pings) {
                ping.paint(this, g2d);
            }

            // Destination and source
            g2d.setColor(Color.BLACK);
            for (Shape destination : destinations) {
                g2d.fill(destination);
            }

            g2d.fill(sourceShape);

            g2d.dispose();
        }

    }

    // Self contained, duration based, animation engine...
    public static class AnimationEngine {

        private Instant startTime;
        private Duration duration;

        private Timer timer;

        private AnimationEngineListener listener;

        public AnimationEngine(Duration duration) {
            this.duration = duration;
        }

        public void start() {
            if (timer != null) {
                return;
            }
            startTime = null;
            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tick();
                }
            });
            timer.start();
        }

        public void stop() {
            timer.stop();
            timer = null;
            startTime = null;
        }

        public void setListener(AnimationEngineListener listener) {
            this.listener = listener;
        }

        public AnimationEngineListener getListener() {
            return listener;
        }

        public Duration getDuration() {
            return duration;
        }

        public double getRawProgress() {
            if (startTime == null) {
                return 0.0;
            }
            Duration duration = getDuration();
            Duration runningTime = Duration.between(startTime, Instant.now());
            double progress = (runningTime.toMillis() / (double) duration.toMillis());

            return Math.min(1.0, Math.max(0.0, progress));
        }

        protected void tick() {
            if (startTime == null) {
                startTime = Instant.now();
            }
            double rawProgress = getRawProgress();
            if (rawProgress >= 1.0) {
                rawProgress = 1.0;
            }

            AnimationEngineListener listener = getListener();
            if (listener != null) {
                listener.animationEngineTicked(this, rawProgress);
            }

            // This is done so if you wish to expand the 
            // animation listener to include start/stop events
            // this won't interfer with the tick event
            if (rawProgress >= 1.0) {
                rawProgress = 1.0;
                stop();
            }
        }

        public static interface AnimationEngineListener {

            public void animationEngineTicked(AnimationEngine source, double progress);
        }
    }

    public class Ping {

        private Point point;
        private Point from;
        private Point to;
        private Color fillColor;

        private Shape dot;

        public Ping(Point from, Point to, Color fillColor) {
            this.from = from;
            this.to = to;
            this.fillColor = fillColor;
            point = new Point(from);

            dot = new Ellipse2D.Double(0, 0, 6, 6);
        }

        public void paint(Container parent, Graphics2D g2d) {
            Graphics2D copy = (Graphics2D) g2d.create();
            int width = dot.getBounds().width / 2;
            int height = dot.getBounds().height / 2;
            copy.translate(point.x - width, point.y - height);
            copy.setColor(fillColor);
            copy.fill(dot);
            copy.dispose();
        }

        public Rectangle getBounds() {
            int width = dot.getBounds().width;
            int height = dot.getBounds().height;

            return new Rectangle(point, new Dimension(width, height));
        }

        public void update(double progress) {
            int x = update(progress, from.x, to.x);
            int y = update(progress, from.y, to.y);

            point.x = x;
            point.y = y;
        }

        protected int update(double progress, int from, int to) {
            int distance = to - from;
            int value = (int) Math.round((double) distance * progress);
            value += from;
            if (from < to) {
                value = Math.max(from, Math.min(to, value));
            } else {
                value = Math.max(to, Math.min(from, value));
            }

            return value;
        }
    }

}