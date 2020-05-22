ExecutorService threadPool = Executors.newFixedThreadPool(4);
List<Callable<String>> tasks = new ArrayList<>();
List<Future<String>> futures = new ArrayList<>();
List<String> result = new ArrayList<>();
tasks.stream().forEachOrdered(task -> futures.add(threadPool.submit(task)));
for (Future<String> future :futures) {
    try {
        result.add(future.get());
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }   
}