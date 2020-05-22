ScheduledExecutorService executor = Executors
            .newScheduledThreadPool(10);
    ScheduledFuture<?> result = executor.scheduleWithFixedDelay(() -> {// do
                                                                        // something
            }, 0, 10, TimeUnit.MILLISECONDS);

    try {
        // this will timeout the task after 5ms. 
        result.get(5, TimeUnit.MILLISECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
        // handle exception
        result.cancel(true); 
    }