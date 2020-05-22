ExecutorService threadPool = Executors.newFixedThreadPool(5);

for (int i = 0; i < 1000; i++) {
   threadPool.submit(new Runnable() {
       public void run() {
           for (int j = 0; j < 1000; j++) {
               doOneFunctionCall();
           }
       }
   });
}