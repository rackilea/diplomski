ExecutorService service = Executors.newSingleThreadExecutor();

try {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            // Database task
        }
    };

    Future<?> f = service.submit(r);

    f.get(2, TimeUnit.MINUTES);     // attempt the task for two minutes
}
catch (final InterruptedException e) {
    // The thread was interrupted during sleep, wait or join
}
catch (final TimeoutException e) {
    // Took too long!
}
catch (final ExecutionException e) {
    // An exception from within the Runnable task
}
finally {
    service.shutdown();
}