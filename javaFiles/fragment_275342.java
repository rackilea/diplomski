private final ExecutorService executor = Executors.newSingleThreadExecutor();

public void task(final int arg) {
    executor.execute(new Runnable() {
        @Override
        public void run() {
            // perform task using `arg`
        }
    });
}