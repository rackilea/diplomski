ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
exec.scheduleAtFixedRate(new Runnable() {
           public void run() {
               System.out.println("Time's Up According To ScheduledThreadPool");
               alive = false;
           }
       }, durationInHours, 1, TimeUnit.HOURS);