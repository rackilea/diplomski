ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
executorService.scheduleWithFixedDelay(new Runnable() {
            public void run() {
              //put query logic here
                }
            }
        }, 10, 5, TimeUnit.MINUTES);