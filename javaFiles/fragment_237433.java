public static <T> void schedule(ScheduledExecutorService scheduler,
            Schedule schedule, Callable<T> task, Consumer<? super T> consumer)
            throws InterruptedException, ExecutionException {
    while (true) {
        if (Thread.interrupted()) throw new InterruptedException();

        long delay = schedule.nextTime() - System.currentTimeMillis();
        if (delay < 0) continue; // skip this step

        ScheduledFuture<? extends T> future = scheduler.schedule(task,
                                              delay, schedule.getUnit());
        consumer.accept(future.get());
    }
}