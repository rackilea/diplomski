private Future future = null;
private long periodMS = 0;

public void setPeriod(long periodMS) {
   if (future != null && this.periodMS == periodMS) return;
   if (future != null) future.cancel(false);
   scheduledExecutorService.scheduleWithFixedDelay(task, periodMS/2, periodMS, TimeUnit.MILLI_SECONDS);
}