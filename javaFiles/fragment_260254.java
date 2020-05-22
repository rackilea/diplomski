List list = getList();
ExecutorService executor = ForkJoinPool.commonPool();
int parallelismLevel = 8;

// Compute the number of element that each thread will compute.
final int elementByThread = (list.size() >= parallelism) ? (list.size() / parallelism) : 1;

// If the number of indices to compute is less than the parallelism level,
// reduce parallelism level to the number of indices.
final int effectiveParallelism = (list.size() >= parallelism) ? parallelism : list.size();

List<Future> futures = new ArrayList<>();
for (int iParallelism = 0; iParallelism < effectiveParallelism; iParallelism++) {
    // Compute sub-list indices.
    int from = iParallelism * elementByThread;
    int to = iParallelism == (effectiveParallelism - 1)
             ? (list.size())
             : ((iParallelism + 1) * elementByThread);

    // Process sub-list asynchronously.
    futures.add(executor.submit(() -> processList(list.subList(from, to))));
}