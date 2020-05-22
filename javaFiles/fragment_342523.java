ExecutorService executorService = Executors.newFixedThreadPool(/*Number of Threads*/);


    for (int i = 0; i < /* Number of Requests */; i++) {
        WorkerThread wt = context.getBean(WorkerThread.class, String.valueOf(i));
        tasks.add(wt);
    }

    List<Future<String>> futures = executorService.invokeAll(tasks);

    for (Future<String> future : futures) {
        String result = future.get(10000, TimeUnit.MILLISECONDS);
    }

    executorService.shutdown();