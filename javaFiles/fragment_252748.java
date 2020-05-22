public void exampleFunction(final int num) { // final int here
     ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
     exec.schedule(new Runnable() {
         public void run() {
             ...do something here...
             ...something with 'num' here...
             ...i get an error when i try to use 'num' here
         }
     }, 10, TimeUnit.SECONDS);
 }