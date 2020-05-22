public void schedule() {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        String str;
        try {
            while ((str = queue.poll()) != null) {
                call(str);  // do further processing
            }
        } catch (IOException e) {
            ferpt.felog("svr class", "consumer", "consumer thread", e.getClass().getName() + ": " + e.getMessage());
        }
    }, 0, 500, TimeUnit.MILLISECONDS);
}