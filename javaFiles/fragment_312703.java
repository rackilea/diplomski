private long periodMS;

public void start() {
  scheduledExecutorService.schedule(this, periodMS, TimeUnit.MILLI_SECONDS);
}

public void run() {
   try {
       task.run();
   } catch(Exception e) {
       // handle e
   }
   start();
}