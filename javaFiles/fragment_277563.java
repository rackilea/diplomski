LinkedBlockingQueue<Runnable> q = new LinkedBlockingQueue<Runnable>();
ThreadPoolExecutor executor = new ThreadPoolExecutor(
        0, // core threads
        10, // max threads
        2, TimeUnit.MILLISECONDS,
        q
);

for (int i = 0; i < 10; i++) {
    final int j = i;
    executor.execute(() ->
        {
           try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           System.out.println(
               "TaskNo:" + j + ":" + Thread.currentThread().getName()
           );
         });
}

executor.shutdown();