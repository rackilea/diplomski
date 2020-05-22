new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(final Runnable r, final ThreadPoolExecutor executor) {
            for (int i = 0; i < 10; i++) {
                if (executor.getQueue().offer(r)) {
                    return;
                }

                try {
                    Thread.sleep(50);
                } catch (final InterruptedException e) {
                    // no-op
                }
            }
            throw new RejectedExecutionException();
        }
    }