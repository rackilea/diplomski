ExecutorService executor = Executors.newFixedThreadPool(3);
for(int i=0; i<5 ;i++)
{
    Worker w = new Worker();
    Future<String> future = executor.submit(w); // (1)
    while(!future.isDone()) // (2)
    {
        //Wait
    }
    String s = future.get();
    System.out.println(LocalDateTime.now()+" "+s);
}
executor.shutdown();
executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);