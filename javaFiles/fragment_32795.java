InstanceFactory instanceFactory = new InstanceFactory();
ExecutorService executor = Executors.newSingleThreadExecutor();
try (Instance instance = instanceFactory.create()) {
    instance.init();
    instance.doStuff();
    while ((input = reader.readNext()) != null) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                instance.put(input);
            }
        });
    }
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.MINUTES);
}