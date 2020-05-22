int coreAmount = 8;

    ExecutorService executor;

    //executor = Executors.newFixedThreadPool(coreAmount);

    int overrun = 4;
    int maxWorkCount = 1_000;
    executor = new ThreadPoolExecutor(coreAmount, coreAmount + overrun, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(maxWorkCount));