ExecutorService workerPool = Executors.newFixedThreadPool(10);
final ExecutorService solutionsPool = Executors.newFixedThreadPool(1);
solutionsPool.submit(workerThatPutsSolutionsIntoSolutionsPool);
...
// once you've submitted your last worker you can do
workerPool.shutdown();

workerPool.waitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
// once the workers have finished you shutdown the solutions pool
solutionsPool.shutdown();
// and then wait for it to finish
solutionsPool.waitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);