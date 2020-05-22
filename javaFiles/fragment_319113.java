class MyTask implements Runnable {
     @Override
         public void run() {
             //do your work here
         }
 }


 ScheduledExecutorService service = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
 service.scheduleAtFixedRate(new MyTask(), 0, 30, TimeUnit.MINUTES);