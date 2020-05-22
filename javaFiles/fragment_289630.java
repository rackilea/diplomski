ScheduledExecutorService scheduleService =   Executors.newScheduledThreadPool(n);
for (int i = 0, i< noOfThreads; i++) { 
   final Future future = service.submit(new ThreadTask());
   scheduleService.schedule(new Runnable(){
       public void run(){
           future.cancel(true);
       }
  }, 10, TimeUnits.MINUTES);
}