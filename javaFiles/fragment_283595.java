ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    executor.setRemoveOnCancelPolicy(true);
    final int rareNumber = 302330233;
    ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
        int x = 0;
        while (true) {
            x++;
            if(x % rareNumber == 0) {
                System.out.println(x);
            }

            if (Thread.interrupted()) {
                return;
            }
        }
    }, 1, 2, TimeUnit.SECONDS);
    Thread.sleep(3_000);

    executor.shutdownNow();
    // I'd like to stop a task here.
    System.out.println("The task is stopped");