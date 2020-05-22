public static void scheduleRepeatedly(final Callable<Status> callable, final int someDelay, final ScheduledExecutorService executor) {
    executor.schedule(new Runnable() {
        @Override
        public void run() {
            Status status = Status.BAD;
            try {
                status = callable.call();
            } catch (Exception e) {
                // whatever logic here to determine if callable should be rescheduled and what the new delay is
                if (status == Status.BAD) {
                    scheduleRepeatedly(callable, someDelay * 2, executor);
                }
            }
        }
    }, someDelay, TimeUnit.SECONDS);
}