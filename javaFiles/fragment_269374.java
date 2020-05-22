private final ExecutorService executor =
        Executors.newFixedThreadPool(1, r -> {
            Thread thread = new Thread(r, "golden-path-marker");
            thread.setPriority(Thread.MAX_PRIORITY);
            return thread;
        });
executor.prestartCoreThread();