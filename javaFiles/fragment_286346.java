ExecutorService executorService = Executors.newFixedThreadPool(4); // number of threads
for (int i = 0; i < n; i++) {
   // declare variables as final which will be used in method run below
   final int count = i;
   executorService.submit(new Runnable() {
       @Override
       public void run() {
           //do your long stuff and can use count variable
       }
   });
}