class ScheduledJob_IntegrationModule_Nested implements ScheduledJob {
    private final IntegrationModule outerThis;
    private final long delay;

    public ScheduledJob_IntegrationModule_Nested(IntegrationModule outerThis, long delay) {
        this.outerThis = outerThis;
        this.delay = delay;
    }

    @Override
    public boolean isRepetitive() {
        return true;
    }

    @Override
    public long getDelay() {
        return delay;
    }

    @Override
    public void runJob() {
        // do some integration stuff
    }
}

public class IntegrationModule implements Module {

    // some other stuff
    ...

    public void register(Scheduler scheduler) {
        final long delay = readDelayConfiguration();
        scheduler.registerJob(new ScheduledJob_IntegrationModule_Nested(this, delay));
    }
}