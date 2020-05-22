// maybe you want 10 threads working on your tasks
ExecutorService threadPool = Executors.newFixedThreadPool(10); 
CompletionService<Result> ecs
     = new ExecutorCompletionService<Result>(threadPool);
for (Callable<Result> task : tasks) {
    // submit your tasks to the completion service, they run in the thread-pool
    ecs.submit(task);
}
// once you get one result
Future<Result> future = ecs.take();
// kill the rest of the tasks
threadPool.shutdownNow();
Result result = future.get();
// probably will need to close the thread connections, see below
// maybe call threadPool.awaitShutdown(...) here to wait for the others to die