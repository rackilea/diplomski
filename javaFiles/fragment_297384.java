private final ScheduledExecutorService executor =
    Executors.newSingleThreadScheduledExecutor();


// is main loop, waits between 10 - 30 ms.  
executor.schedule(new Runnable() { public void run() {
   // my delayed task
}}, 10 + new Random().nextInt(20), TimeUnit.MILLI_SECOND);