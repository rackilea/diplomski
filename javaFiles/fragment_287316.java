//Start as many threads as you want upon button click... (since you said i want to kill all other threads, so i assume you want to start some threads soon upon button click)
            ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
            service.schedule(new Thread(), 0, TimeUnit.SECONDS);
            service.schedule(new Thread(), 0, TimeUnit.SECONDS);
            service.schedule(new Thread(), 0, TimeUnit.SECONDS);

            //Start single thread after 3 seconds.
            ScheduledExecutorService serviceCheck = Executors.newScheduledThreadPool(3);
            serviceCheck.schedule(new Thread(), 3, TimeUnit.SECONDS);
            //In this thread created using "serviceCheck", check with value has not changed then use `service.shutdownNow();` to shutdown all previously started threads and then do whatever you want.