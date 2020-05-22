import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

public class Reveal extends JPanel {

    public static void main(String[] args) {
        new Reveal();
    }

    public Reveal() {
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

        private IntAnimatable animatable;

        private List<ImageIcon> icons = new ArrayList<>(25);
        private JLabel label = new JLabel();

        public TestPane() {
            setLayout(new GridBagLayout());
            IntRange range = new IntRange(0, 111);
            animatable = new IntAnimatable(range, Duration.ofSeconds(4), Easement.SLOWOUT, new AnimatableListener<Integer>() {
                @Override
                public void animationChanged(Animatable<Integer> animator) {
                    int value = animator.getValue();
                    int index = value % 7;
                    ImageIcon icon = icons.get(index);
                    if (label.getIcon() != icon) {
                        label.setIcon(icon);
                    }
                }
            }, new AnimatableLifeCycleAdapter<Integer>() {
                @Override
                public void animationCompleted(Animatable<Integer> animator) {
                    BufferedImage img = makeImage(3);
                    writeTextOverImage("Lucky number", img);
                    ImageIcon luckNumber = new ImageIcon(img);
                    label.setIcon(luckNumber);
                }
            });

            for (int index = 0; index < 7; index++) {
                icons.add(new ImageIcon(makeImage(index)));
            }
            Collections.shuffle(icons);

            add(label);

            Animator.INSTANCE.add(animatable);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    protected void writeTextOverImage(String text, BufferedImage img) {
        Graphics2D g2d = img.createGraphics();
        Font font = g2d.getFont();
        font = font.deriveFont(Font.BOLD, font.getSize2D() + 2);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = img.getWidth();
        int height = img.getWidth();
        int x = (width - fm.stringWidth(text)) / 2;
        int y = fm.getAscent();
        g2d.setColor(Color.YELLOW);
        g2d.drawString(text, x, y);
        g2d.dispose();
    }

    protected BufferedImage makeImage(int h) {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        FontMetrics fm = g2d.getFontMetrics();
        String text = Integer.toString(h);
        int x = (100 - fm.stringWidth(text)) / 2;
        int y = ((100 - fm.getHeight()) / 2) + fm.getAscent();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 100, 100);
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, x, y);
        g2d.dispose();
        return img;
    }

    /**** Range ****/
    /* 
    A lot of animation is done from one point to another, this just
    provides a self contained concept of a range which can be used to 
    calculate the value based on the current progression over time
    */

    public abstract class Range<T> {

        private T from;
        private T to;

        public Range(T from, T to) {
            this.from = from;
            this.to = to;
        }

        public T getFrom() {
            return from;
        }

        public T getTo() {
            return to;
        }

        @Override
        public String toString() {
            return "From " + getFrom() + " to " + getTo();
        }

        public abstract T valueAt(double progress);

    }

    public class IntRange extends Range<Integer> {

        public IntRange(Integer from, Integer to) {
            super(from, to);
        }

        public Integer getDistance() {
            return getTo() - getFrom();
        }

        @Override
        public Integer valueAt(double progress) {
            int distance = getDistance();
            int value = (int) Math.round((double) distance * progress);
            value += getFrom();

            return value;
        }
    }

    /**** Animatable ****/
    /*
    The core concept of something that is animatable.  This basic wraps up the 
    logic for calculating the progression of the animation over a period of time
    and then use that to calculate the value of the range and then the observers
    are notified so they can do stuff
    */

    public class IntAnimatable extends AbstractAnimatableRange<Integer> {

        public IntAnimatable(IntRange animationRange, Duration duration, Easement easement, AnimatableListener<Integer> listener, AnimatableLifeCycleListener<Integer> lifeCycleListener) {
            super(animationRange, duration, easement, listener, lifeCycleListener);
        }

    }

    public interface AnimatableListener<T> {

        public void animationChanged(Animatable<T> animator);
    }

    public interface AnimatableLifeCycleListener<T> {

        public void animationStopped(Animatable<T> animator);

        public void animationCompleted(Animatable<T> animator);

        public void animationStarted(Animatable<T> animator);

        public void animationPaused(Animatable<T> animator);
    }

    public interface Animatable<T> {

        public T getValue();

        public void tick();

        public Duration getDuration();

        public Easement getEasement();

        // Wondering if these should be part of a secondary interface
        // Provide a "self managed" unit of work
        public void start();

        public void stop();

        public void pause();
    }

    public class AnimatableLifeCycleAdapter<T> implements AnimatableLifeCycleListener<T> {

        @Override
        public void animationStopped(Animatable<T> animator) {
        }

        @Override
        public void animationCompleted(Animatable<T> animator) {
        }

        @Override
        public void animationStarted(Animatable<T> animator) {
        }

        @Override
        public void animationPaused(Animatable<T> animator) {
        }

    }

    public abstract class AbstractAnimatable<T> implements Animatable<T> {

        private LocalDateTime startTime;
        private Duration duration = Duration.ofSeconds(5);
        private AnimatableListener<T> animatableListener;
        private AnimatableLifeCycleListener<T> lifeCycleListener;
        private Easement easement;
        private double rawOffset;

        public AbstractAnimatable(Duration duration, AnimatableListener<T> listener) {
            this.animatableListener = listener;
            this.duration = duration;
        }

        public AbstractAnimatable(Duration duration, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
            this(duration, listener);
            this.lifeCycleListener = lifeCycleListener;
        }

        public AbstractAnimatable(Duration duration, Easement easement, AnimatableListener<T> listener) {
            this(duration, listener);
            this.easement = easement;
        }

        public AbstractAnimatable(Duration duration, Easement easement, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
            this(duration, easement, listener);
            this.lifeCycleListener = lifeCycleListener;
        }

        public void setEasement(Easement easement) {
            this.easement = easement;
        }

        @Override
        public Easement getEasement() {
            return easement;
        }

        public Duration getDuration() {
            return duration;
        }

        protected void setDuration(Duration duration) {
            this.duration = duration;
        }

        public double getCurrentProgress(double rawProgress) {
            Easement easement = getEasement();
            double progress = Math.min(1.0, Math.max(0.0, getRawProgress()));
            if (easement != null) {
                progress = easement.interpolate(progress);
            }
            return Math.min(1.0, Math.max(0.0, progress));
        }

        public double getRawProgress() {
            if (startTime == null) {
                return 0.0;
            }
            Duration duration = getDuration();
            Duration runningTime = Duration.between(startTime, LocalDateTime.now());
            double progress = rawOffset + (runningTime.toMillis() / (double) duration.toMillis());

            return Math.min(1.0, Math.max(0.0, progress));
        }

        @Override
        public void tick() {
            if (startTime == null) {
                startTime = LocalDateTime.now();
                fireAnimationStarted();
            }
            double rawProgress = getRawProgress();
            double progress = getCurrentProgress(rawProgress);
            if (rawProgress >= 1.0) {
                progress = 1.0;
            }

            tick(progress);

            fireAnimationChanged();
            if (rawProgress >= 1.0) {
                fireAnimationCompleted();
            }
        }

        protected abstract void tick(double progress);

        @Override
        public void start() {
            if (startTime != null) {
                // Restart?
                return;
            }
            Animator.INSTANCE.add(this);
        }

        @Override
        public void stop() {
            stopWithNotitifcation(true);
        }

        @Override
        public void pause() {
            rawOffset += getRawProgress();
            stopWithNotitifcation(false);

            double remainingProgress = 1.0 - rawOffset;
            Duration remainingTime = getDuration().minusMillis((long) remainingProgress);
            setDuration(remainingTime);

            lifeCycleListener.animationStopped(this);
        }

        protected void fireAnimationChanged() {
            if (animatableListener == null) {
                return;
            }
            animatableListener.animationChanged(this);
        }

        protected void fireAnimationCompleted() {
            stopWithNotitifcation(false);
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationCompleted(this);
        }

        protected void fireAnimationStarted() {
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationStarted(this);
        }

        protected void fireAnimationPaused() {
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationPaused(this);
        }

        protected void stopWithNotitifcation(boolean notify) {
            Animator.INSTANCE.remove(this);
            startTime = null;
            if (notify) {
                if (lifeCycleListener == null) {
                    return;
                }
                lifeCycleListener.animationStopped(this);
            }
        }

    }

    public abstract class AbstractAnimatableRange<T> extends AbstractAnimatable<T> {

        private Range<T> range;
        private T value;

        public AbstractAnimatableRange(Range<T> range, Duration duration, AnimatableListener<T> listener) {
            super(duration, listener);
            this.range = range;
        }

        public AbstractAnimatableRange(Range<T> range, Duration duration, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
            super(duration, listener, lifeCycleListener);
            this.range = range;
        }

        public AbstractAnimatableRange(Range<T> range, Duration duration, Easement easement, AnimatableListener<T> listener) {
            super(duration, easement, listener);
            this.range = range;
        }

        public AbstractAnimatableRange(Range<T> range, Duration duration, Easement easement, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
            super(duration, easement, listener, lifeCycleListener);
            this.range = range;
        }

        protected void tick(double progress) {
            setValue(range.valueAt(progress));
        }

        protected void setValue(T value) {
            this.value = value;
        }

        @Override
        public T getValue() {
            return value;
        }

    }

    /*
    Easement, complicated, but fun
    */
    public enum Easement {
        SLOWINSLOWOUT(1d, 0d, 0d, 1d), FASTINSLOWOUT(0d, 0d, 1d, 1d), SLOWINFASTOUT(0d, 1d, 0d, 0d), SLOWIN(1d, 0d, 1d, 1d), SLOWOUT(0d, 0d, 0d, 1d);
        private final double[] points;
        private final List<PointUnit> normalisedCurve;

        private Easement(double x1, double y1, double x2, double y2) {
            points = new double[]{x1, y1, x2, y2};
            final List<Double> baseLengths = new ArrayList<>();
            double prevX = 0;
            double prevY = 0;
            double cumulativeLength = 0;
            for (double t = 0; t <= 1; t += 0.01) {
                Point2D xy = getXY(t);
                double length = cumulativeLength + Math.sqrt((xy.getX() - prevX) * (xy.getX() - prevX) + (xy.getY() - prevY) * (xy.getY() - prevY));
                baseLengths.add(length);
                cumulativeLength = length;
                prevX = xy.getX();
                prevY = xy.getY();
            }
            normalisedCurve = new ArrayList<>(baseLengths.size());
            int index = 0;
            for (double t = 0; t <= 1; t += 0.01) {
                double length = baseLengths.get(index++);
                double normalLength = length / cumulativeLength;
                normalisedCurve.add(new PointUnit(t, normalLength));
            }
        }

        public double interpolate(double fraction) {
            int low = 1;
            int high = normalisedCurve.size() - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                if (fraction > normalisedCurve.get(mid).getPoint()) {
                    low = mid + 1;
                } else if (mid > 0 && fraction < normalisedCurve.get(mid - 1).getPoint()) {
                    high = mid - 1;
                } else {
                    break;
                }
            }
            /*
         * The answer lies between the "mid" item and its predecessor.
             */
            final PointUnit prevItem = normalisedCurve.get(mid - 1);
            final double prevFraction = prevItem.getPoint();
            final double prevT = prevItem.getDistance();
            final PointUnit item = normalisedCurve.get(mid);
            final double proportion = (fraction - prevFraction) / (item.getPoint() - prevFraction);
            final double interpolatedT = prevT + (proportion * (item.getDistance() - prevT));
            return getY(interpolatedT);
        }

        protected Point2D getXY(double t) {
            final double invT = 1 - t;
            final double b1 = 3 * t * invT * invT;
            final double b2 = 3 * t * t * invT;
            final double b3 = t * t * t;
            final Point2D xy = new Point2D.Double((b1 * points[0]) + (b2 * points[2]) + b3, (b1 * points[1]) + (b2 * points[3]) + b3);
            return xy;
        }

        protected double getY(double t) {
            final double invT = 1 - t;
            final double b1 = 3 * t * invT * invT;
            final double b2 = 3 * t * t * invT;
            final double b3 = t * t * t;
            return (b1 * points[2]) + (b2 * points[3]) + b3;
        }

        protected class PointUnit {

            private final double distance;
            private final double point;

            public PointUnit(double distance, double point) {
                this.distance = distance;
                this.point = point;
            }

            public double getDistance() {
                return distance;
            }

            public double getPoint() {
                return point;
            }
        }

    }

    /**** Core Animation Engine ****/

    public enum Animator {
        INSTANCE;
        private Timer timer;
        private List<Animatable> properies;

        private Animator() {
            properies = new ArrayList<>(5);
            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Animatable> copy = new ArrayList<>(properies);
                    Iterator<Animatable> it = copy.iterator();
                    while (it.hasNext()) {
                        Animatable ap = it.next();
                        ap.tick();
                    }
                    if (properies.isEmpty()) {
                        timer.stop();
                    }
                }
            });
        }

        public void add(Animatable ap) {
            properies.add(ap);
            timer.start();
        }

        protected void removeAll(List<Animatable> completed) {
            properies.removeAll(completed);
        }

        public void remove(Animatable ap) {
            properies.remove(ap);
            if (properies.isEmpty()) {
                timer.stop();
            }
        }

    }

}