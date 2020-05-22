public class IntegrationModule implements Module {

    // some other stuff
    ...

    public void register(Scheduler scheduler) {
        final long delay = readDelayConfiguration();
        scheduler.registerJob(new ScheduledJob_IntegrationModule_Nested(this, delay));
    }


    static class IntegrationScheduledJob implements ScheduledJob {
        private final long delay;

        public IntegrationScheduledJob(long delay) {
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
}