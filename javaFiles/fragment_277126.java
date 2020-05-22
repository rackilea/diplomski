static class DelegatedScheduledExecutorService
        extends DelegatedExecutorService
        implements ScheduledExecutorService {

    private final ScheduledExecutorService e;

    DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
        super(executor);
        e = executor;
    }

    // (...)
}