private static final ScheduledExecutorService worker = 
Executors.newSingleThreadScheduledExecutor();

void someMethod() {
 ⋮
Runnable task = new Runnable() {
public void run() {
  /* Do something… */
}
};
worker.schedule(task, 5, TimeUnit.SECONDS);
⋮
}