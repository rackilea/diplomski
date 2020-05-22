ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    final Runnable notificationTask = new Runnable() {
        @Override public void run() {
            updater.sendUpdate();                          // just *notify* the updater to do an update
        }
    };

    executor.scheduleAtFixedRate(
        notificationTask, 0, 33333333, TimeUnit.NANOSECONDS // freakishly accurate :)
    );