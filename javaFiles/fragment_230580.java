final List<Future<...>> subJobs = new ArrayList<>();
...
while (true) {
   if (Thread.currentThread().isInterrupted()) {
      cleanupSubJobs(subJobs);
      break;
   }
   try {
      Thread.sleep(...);
   } catch (InterruptedException ie) {
      // always a good pattern
      Thread.currentThread.interrupt();
      cleanupSubJobs(subJobs);
      return;
   }
   ...
   if (weNeedSubJob) {
      subJobs.add(threadPool.submit(...));
   }
}
...
private void cleanupSubJobs(List<Future<...>> subJobs) {
   for (Future<...> subJob : subJobs) {
      subJob.cancel(true);
   }
}