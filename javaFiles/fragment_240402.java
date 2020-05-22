int threads = Runtime.getRuntime().availableProcessors();
ExecutorService service = Executors.newFixedThreadPool(threads);
for (int i = 0; i < 36; i++) {
    service.execute(new Runnable() {
        public void run() {
            // do what you need per file here
        }
    });
}
service.shutdown();