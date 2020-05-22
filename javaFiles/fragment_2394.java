static final int THREADS = Runnable.getRuntime().availableProcesses();  

ExecutorService service = Executors.newFixedThreadPool(THREADS);

List<Future<Long>> futureQueue = new ArrayList<Future<Long>>(end);  
for (int i = 0; i < end; i++)
    futureQueue.add(executor.submit(new MyRunnable()));