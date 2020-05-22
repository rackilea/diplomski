public final class ExceptionSwallowingRunnable implements Runnable {
    private final Runnable delegate;

    public ExceptionSwallowingRunnable(Runnable delegate) {
        // TODO: Argument validation
        this.delegate = delegate;
    }

    @Override public void run() {
        try {
            delegate.run();
        } catch (RuntimeException e) {
            // Logging etc
        }
    }
}