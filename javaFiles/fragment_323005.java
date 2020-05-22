// create executor that consists of 1 thread
final ExecutorService e = Executors.newScheduledThreadPool(1);

// schedule it to execute every 5000 ms starting from now
((ScheduledExecutorService) e).scheduleAtFixedRate(new Runnable(){
     @Override
     public void run() {
         // your repeating task
     }                  
}, 0, 5000, TimeUnit.MILLISECONDS);