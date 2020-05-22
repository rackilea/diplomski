ScheduledExecutorService executor = Executors.newScheduledThreadPool(2); 
 final Future handler = executor.submit(new Callable(){ ... });
 executor.schedule(new Runnable(){
     public void run(){
         handler.cancel();
     }      
 }, 10000, TimeUnit.MILLISECONDS);