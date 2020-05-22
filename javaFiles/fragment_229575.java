ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(new Runnable() {
           @Override public void run() 
           {
                  while(!Thread.currentThread().isInterrupted());

            }
   });

   es.shutdownNow();