final int processors = Runtime.getRuntime().availableProcessors();
final ExecutorService executor = Executors.newFixedThreadPool(processors); 
final AtomicLong nextCompare = new AtomicLong(0);

for(int i =0; i<processors; i++) { 
  Runnable task = new Thread(bloblist, nextCompare); 
  executor.execute(task);
}   
executor.shutdown();