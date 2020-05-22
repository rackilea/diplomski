class MyTask implements Runnable {

  @Override
  public void run() {
    System.out.println("Hello world");
  } 
}

ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
long period = 100; // the period between successive executions
exec.scheduleAtFixedRate(new MyTask(), 0, period, TimeUnit.MICROSECONDS);
long delay = 100; //the delay between the termination of one execution and the commencement of the next
exec.scheduleWithFixedDelay(new MyTask(), 0, delay, TimeUnit.MICROSECONDS);