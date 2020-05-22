public interface Module {
    void register(Scheduler scheduler);
}

public class IntegrationModule implements Module {

    private java.sql.Connection db;

    private long readDelayConfiguration() {
        // read data from DB
    }

    public void register(Scheduler scheduler) {
        final long delay = readDelayConfiguration();

        scheduler.registerJob(new ScheduledJob() {
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
        });
    }
}