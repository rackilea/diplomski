ExecutorService service = Executors.newFixedThreadPool(3);
for (int i = 1; i <= 5; i++) {
    final int id = i;
    service.submit(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            System.out.println("This is task #" + id);
            Thread.sleep(1000);
            return null;
        }
    });
}
System.out.println("All tasks added");
service.shutdown();
service.awaitTermination(1, TimeUnit.HOURS);
System.out.println("All done, threadpool closed");