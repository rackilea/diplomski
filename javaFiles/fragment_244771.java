//ForkJoinPool common
Executor exec = ForkJoinPool.commonPool();

//Expanding thread pool
Executor exec = Executors.newCachedThreadPool();

//Just execute on the current thread
Executor exec = (Runnable r)  -> r.run();