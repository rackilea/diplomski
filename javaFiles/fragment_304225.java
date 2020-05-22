// Self contained, duration based, animation engine...
public class AnimationEngine {

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