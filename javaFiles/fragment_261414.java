ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
Producer producer = new Producer(q);
Consumer consumer = new Consumer(q);
executor.submit(producer::run);
executor.submit(consumer::run);
Runtime.getRuntime().addShutdownHook(new Thread(executor::shutdownNow));