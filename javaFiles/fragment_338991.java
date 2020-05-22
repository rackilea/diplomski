public void allSucceed(final List<MyRunnable> tasks) {
    if (tasks == null || tasks.size() == 0)
        return;

    int status = 0;

    boolean success = true;
    do {
        final ExecutorService executorService = Executors
                .newFixedThreadPool(tasks.size());
        final CompletionService<MyRunnable> completionService = new ExecutorCompletionService<MyRunnable>(
                executorService);
        for (final MyRunnable task : tasks) {
            completionService.submit(task, task);
        }

        for (int i = 0; i < tasks.size(); i++) {
            try {
                status = completionService.take().get().getStatus();
            } catch (final Exception e) {
                success = false;
                break;
            }

            if (status == 0) {
                System.out.println("A task failed. All will be rerun");
                executorService.shutdownNow();
                success = false;
                break;
            }
        }
    } while (!success);
}