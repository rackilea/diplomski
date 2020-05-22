133       public static ExecutorService newSingleThreadExecutor() {
  134           return new FinalizableDelegatedExecutorService
  135               (new ThreadPoolExecutor(1, 1,
  136                                       0L, TimeUnit.MILLISECONDS,
  137                                       new LinkedBlockingQueue<Runnable>()));
  138       }