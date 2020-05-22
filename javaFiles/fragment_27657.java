import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private EventTimeLine<Note> musicTimeLine;
        private DefaultDurationAnimatable timeLineAnimatable;

        private Double playProgress;

        private Set<Note> playing = new HashSet<Note>(5);
        private Map<Note, Double> noteAlpha = new HashMap<>(5);

        private DoubleBlender blender = new DoubleBlender();
        private BlendingTimeLine<Double> alphaTimeLine = new BlendingTimeLine<>(blender);

        public TestPane() {
            musicTimeLine = new EventTimeLine<Note>();
            musicTimeLine.add(0.1f, new Note(Duration.ofMillis(1000)));
            musicTimeLine.add(0.12f, new Note(Duration.ofMillis(500)));
            musicTimeLine.add(0.2f, new Note(Duration.ofMillis(500)));
            musicTimeLine.add(0.21f, new Note(Duration.ofMillis(500)));
            musicTimeLine.add(0.22f, new Note(Duration.ofMillis(500)));
            musicTimeLine.add(0.25f, new Note(Duration.ofMillis(1000)));
            musicTimeLine.add(0.4f, new Note(Duration.ofMillis(2000)));
            musicTimeLine.add(0.5f, new Note(Duration.ofMillis(2000)));
            musicTimeLine.add(0.7f, new Note(Duration.ofMillis(2000)));
            musicTimeLine.add(0.8f, new Note(Duration.ofMillis(2000)));

            alphaTimeLine.add(0.0f, 0.0);
            alphaTimeLine.add(0.5f, 1.0);
            alphaTimeLine.add(1.0f, 0.0);

            timeLineAnimatable = new DefaultDurationAnimatable(Duration.ofSeconds(10),
                    new AnimatableListener() {
                @Override
                public void animationChanged(Animatable animator) {
                    double progress = timeLineAnimatable.getPlayedDuration();
                    playProgress = progress;
                    List<Note> notes = musicTimeLine.getValuesAt(progress);
                    if (notes.size() > 0) {
                        System.out.println(">> " + progress + " @ " + notes.size());
                        for (Note note : notes) {
                            playNote(note);
                        }
                    }
                    repaint();
                }
            }, null);

            timeLineAnimatable.start();
        }

        protected void playNote(Note note) {
            // Note is already playing...
            // Equally, we could maintain a reference to the animator, mapped to
            // the note, but what ever...
            if (playing.contains(note)) {
                return;
            }
            playing.add(note);

            DurationAnimatable noteAnimatable = new DefaultDurationAnimatable(note.getDuration(), new AnimatableListener() {
                @Override
                public void animationChanged(Animatable animator) {
                    DurationAnimatable da = (DurationAnimatable) animator;
                    double progress = da.getPlayedDuration();
                    double alpha = alphaTimeLine.getValueAt((float) progress);
                    noteAlpha.put(note, alpha);
                    repaint();
                }
            }, new AnimatableLifeCycleListenerAdapter() {
                @Override
                public void animationCompleted(Animatable animator) {
                    playing.remove(note);
                    noteAlpha.remove(note);
                    repaint();
                }
            });
            noteAnimatable.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int startX = 10;
            int endX = getWidth() - 10;
            int range = endX - startX;

            int yPos = getHeight() / 2;

            g2d.setColor(Color.DARK_GRAY);
            g2d.drawLine(startX, yPos, endX, yPos);

            List<Note> notes = musicTimeLine.getValues();
            for (Note note : notes) {
                double potl = musicTimeLine.getPointOnTimeLineFor(note);
                double xPos = startX + (range * potl);
                // Technically, this could be cached...
                Ellipse2D notePoint = new Ellipse2D.Double(xPos - 2.5, yPos - 2.5, 5, 5);
                g2d.fill(notePoint);

                if (noteAlpha.containsKey(note)) {
                    double alpha = noteAlpha.get(note);
                    // I'm lazy :/
                    // It's just simpler to copy the current context, modify the
                    // composite, paint and then dispose of, then trying to 
                    // track and reset the composite manually
                    Graphics2D alpha2d = (Graphics2D) g2d.create();
                    alpha2d.setComposite(AlphaComposite.SrcOver.derive((float) alpha));
                    Ellipse2D playedNote = new Ellipse2D.Double(xPos - 5, yPos - 5, 10, 10);
                    alpha2d.setColor(Color.RED);
                    alpha2d.fill(playedNote);
                    alpha2d.dispose();
                }
            }

            double playXPos = startX + (range * playProgress);
            g2d.setColor(Color.RED);
            Line2D playLine = new Line2D.Double(playXPos, 0, playXPos, getHeight());
            g2d.draw(playLine);

            g2d.dispose();
        }

    }

    public class Note {

        private Duration duration;

        public Note(Duration duration) {
            this.duration = duration;
        }

        public Duration getDuration() {
            return duration;
        }
    }

    public static class EventTimeLine<T> {

        private Map<Double, KeyFrame<T>> mapEvents;

        public EventTimeLine() {
            mapEvents = new TreeMap<>();
        }

        public void add(double progress, T value) {
            mapEvents.put(progress, new KeyFrame<T>(progress, value));
        }

        public List<T> getValues() {
            return Collections.unmodifiableList(mapEvents.values().stream()
                    .map(kf -> kf.getValue())
                    .collect(Collectors.toList()));
        }

        public double getPointOnTimeLineFor(T value) {
            for (Map.Entry<Double, KeyFrame<T>> entry : mapEvents.entrySet()) {
                if (entry.getValue().getValue() == value) {
                    return entry.getKey();
                }
            }

            return -1;
        }

        public List<T> getValuesAt(double progress) {

            if (progress < 0) {
                progress = 0;
            } else if (progress > 1) {
                progress = 1;
            }

            return getKeyFramesBetween(progress, 0.01f)
                    .stream()
                    .map(kf -> kf.getValue())
                    .collect(Collectors.toList());
        }

        public List<KeyFrame<T>> getKeyFramesBetween(double progress, double delta) {

            int startAt = 0;

            List<Double> keyFrames = new ArrayList<>(mapEvents.keySet());
            while (startAt < keyFrames.size() && keyFrames.get(startAt) <= progress - delta) {
                startAt++;
            }

            startAt = Math.min(keyFrames.size() - 1, startAt);
            int endAt = startAt;
            while (endAt < keyFrames.size() && keyFrames.get(endAt) <= progress + delta) {
                endAt++;
            }
            endAt = Math.min(keyFrames.size() - 1, endAt);

            List<KeyFrame<T>> frames = new ArrayList<>(5);
            for (int index = startAt; index <= endAt; index++) {
                KeyFrame<T> keyFrame = mapEvents.get(keyFrames.get(index));
                if (keyFrame.getProgress() >= progress - delta
                        && keyFrame.getProgress() <= progress + delta) {
                    frames.add(keyFrame);
                }
            }

            return frames;

        }

        public class KeyFrame<T> {

            private double progress;
            private T value;

            public KeyFrame(double progress, T value) {
                this.progress = progress;
                this.value = value;
            }

            public double getProgress() {
                return progress;
            }

            public T getValue() {
                return value;
            }

            @Override
            public String toString() {
                return "KeyFrame progress = " + getProgress() + "; value = " + getValue();
            }

        }

    }

    public static class BlendingTimeLine<T> {

        private Map<Float, KeyFrame<T>> mapEvents;

        private Blender<T> blender;

        public BlendingTimeLine(Blender<T> blender) {
            mapEvents = new TreeMap<>();
            this.blender = blender;
        }

        public void setBlender(Blender<T> blender) {
            this.blender = blender;
        }

        public Blender<T> getBlender() {
            return blender;
        }

        public void add(float progress, T value) {
            mapEvents.put(progress, new KeyFrame<T>(progress, value));
        }

        public T getValueAt(float progress) {
            if (progress < 0) {
                progress = 0;
            } else if (progress > 1) {
                progress = 1;
            }

            List<KeyFrame<T>> keyFrames = getKeyFramesBetween(progress);

            float max = keyFrames.get(1).progress - keyFrames.get(0).progress;
            float value = progress - keyFrames.get(0).progress;
            float weight = value / max;

            T blend = blend(keyFrames.get(0).getValue(), keyFrames.get(1).getValue(), 1f - weight);
            return blend;
        }

        public List<KeyFrame<T>> getKeyFramesBetween(float progress) {

            List<KeyFrame<T>> frames = new ArrayList<>(2);
            int startAt = 0;
            Float[] keyFrames = mapEvents.keySet().toArray(new Float[mapEvents.size()]);
            while (startAt < keyFrames.length && keyFrames[startAt] <= progress) {
                startAt++;
            }

            startAt = Math.min(startAt, keyFrames.length - 1);

            frames.add(mapEvents.get(keyFrames[startAt - 1]));
            frames.add(mapEvents.get(keyFrames[startAt]));

            return frames;

        }

        protected T blend(T start, T end, float ratio) {
            return blender.blend(start, end, ratio);
        }

        public static interface Blender<T> {

            public T blend(T start, T end, float ratio);
        }

        public class KeyFrame<T> {

            private float progress;
            private T value;

            public KeyFrame(float progress, T value) {
                this.progress = progress;
                this.value = value;
            }

            public float getProgress() {
                return progress;
            }

            public T getValue() {
                return value;
            }

            @Override
            public String toString() {
                return "KeyFrame progress = " + getProgress() + "; value = " + getValue();
            }

        }

    }

    public class DoubleBlender implements BlendingTimeLine.Blender<Double> {

        @Override
        public Double blend(Double start, Double end, float ratio) {
            double ir = (double) 1.0 - ratio;
            return (double) (start * ratio + end * ir);
        }

    }

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

    // Reprepresents a linear animation
    public interface Animatable {

        public void tick();

        public void start();

        public void stop();
    }

    public interface DurationAnimatable extends Animatable {
        public Duration getDuration();
        public Double getPlayedDuration();
    }

    public abstract class AbstractAnimatable implements Animatable {

        private AnimatableListener animatableListener;
        private AnimatableLifeCycleListener lifeCycleListener;

        public AbstractAnimatable(AnimatableListener listener) {
            this(listener, null);
        }

        public AbstractAnimatable(AnimatableListener listener, AnimatableLifeCycleListener lifeCycleListener) {
            this.animatableListener = listener;
            this.lifeCycleListener = lifeCycleListener;
        }

        public AnimatableLifeCycleListener getLifeCycleListener() {
            return lifeCycleListener;
        }

        public AnimatableListener getAnimatableListener() {
            return animatableListener;
        }

        @Override
        public void tick() {
            fireAnimationChanged();
        }

        @Override
        public void start() {
            fireAnimationStarted();
            Animator.INSTANCE.add(this);
        }

        @Override
        public void stop() {
            fireAnimationStopped();
            Animator.INSTANCE.remove(this);
        }

        protected void fireAnimationChanged() {
            if (animatableListener == null) {
                return;
            }
            animatableListener.animationChanged(this);
        }

        protected void fireAnimationStarted() {
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationStarted(this);
        }

        protected void fireAnimationStopped() {
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationStopped(this);
        }

    }

    public interface AnimatableListener {

        public void animationChanged(Animatable animator);
    }

    public interface AnimatableLifeCycleListener {

        public void animationCompleted(Animatable animator);

        public void animationStarted(Animatable animator);

        public void animationPaused(Animatable animator);

        public void animationStopped(Animatable animator);
    }

    public class AnimatableLifeCycleListenerAdapter implements AnimatableLifeCycleListener {

        @Override
        public void animationCompleted(Animatable animator) {
        }

        @Override
        public void animationStarted(Animatable animator) {
        }

        @Override
        public void animationPaused(Animatable animator) {
        }

        @Override
        public void animationStopped(Animatable animator) {
        }

    }

    public class DefaultDurationAnimatable extends AbstractAnimatable implements DurationAnimatable {

        private Duration duration;
        private Instant startTime;

        public DefaultDurationAnimatable(Duration duration, AnimatableListener listener, AnimatableLifeCycleListener lifeCycleListener) {
            super(listener, lifeCycleListener);
            this.duration = duration;
        }

        @Override
        public Duration getDuration() {
            return duration;
        }

        @Override
        public Double getPlayedDuration() {
            if (startTime == null) {
                return 0.0;
            }
            Duration duration = getDuration();
            Duration runningTime = Duration.between(startTime, Instant.now());
            double progress = (runningTime.toMillis() / (double) duration.toMillis());

            return Math.min(1.0, Math.max(0.0, progress));
        }

        @Override
        public void tick() {
            if (startTime == null) {
                startTime = Instant.now();
                fireAnimationStarted();
            }
            fireAnimationChanged();
            if (getPlayedDuration() >= 1.0) {
                fireAnimationCompleted();
                stop();
            }
        }

        protected void fireAnimationCompleted() {
            AnimatableLifeCycleListener lifeCycleListener = getLifeCycleListener();
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationCompleted(this);
        }

    }

}