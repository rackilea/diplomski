Callable<TaskResult> task = () -> {
    // ...
    return TaskResult.of(() -> needToBeScheduled(), () -> needToBeResubmitted());
};

final Future<TaskResult> future = threadPool.submit(task);

try {
    final TaskResult result = future.get();

    if (result.needToBeScheduled()) {
        threadPool.schedule(task, delay, TimeUnit.MINUTES);
    }

    if (result.needToBeResubmitted()) {
        threadPool.submit(task);
    }
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}