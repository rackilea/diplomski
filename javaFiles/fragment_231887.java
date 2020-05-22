public abstract class StatefulRequestProcessor {
    protected final Scheduler scheduler;
    protected final HttpRequest request;

    public StatefulRequestProcessor(Scheduler scheduler, HttpRequest request) {
        this.scheduler = scheduler;
        this.request = request;
    }

    public abstract void process();
}