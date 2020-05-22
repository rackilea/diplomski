ExecutorService threadPool = Executors.newFixedThreadPool(5);

for (int i = 0; i < 1000000; i++) {
   threadPool.submit(new Runnable() {
       public void run() {
           doOneFunctionCall();
       }
   });
}