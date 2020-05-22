public class MyStatefulRequestProcessor extends StatefulRequestProcessor {
    public MyStatefulRequestProcessor(Scheduler scheduler, HttpRequest request) {
        super(scheduler, request);
    }

    @Override
    public void process() {

        // do some processing and finally get some stored ID
        ...
        final long id = ...

        // register a clean up of that ID
        scheduler.registerJob(new ScheduledJob() {
            @Override
            public boolean isRepetitive() {
                return false;
            }

            @Override
            public long getDelay() {
                return 24 * 60 * 60 * 1000L; // one day later
            }

            @Override
            public void runJob() {
                // do some clean up
                cleanUp(id);
            }
        });
    }
}