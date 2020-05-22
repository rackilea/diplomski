ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
executor.setKeepAliveTime(1, TimeUnit.MINUTES);
executor.allowCoreThreadTimeOut(true);
for (long i = 0; i < 1000; i++) {
    executor.scheduleAtFixedRate(new Runnable() {

        @Override
        public void run() {
        }
    }, 0, 1, TimeUnit.NANOSECONDS);
}