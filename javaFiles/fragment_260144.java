while (true) {
  try {
    WorkUnit<String> wu = lbq.poll(10, TimeUnit.MILLISECONDS);
    if (wu != null) { doAction(wu.getWork()); }
  } catch (InterruptedException e) {
     Thread.currentThread().interrupt();
     return;
  }
}