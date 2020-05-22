public Thread() {
   init(null, null, "Thread-" + nextThreadNum(), 0);
}

private void init(ThreadGroup g, Runnable target, String name, long stackSize) {
   ...
   /* Set thread ID */
   tid = nextThreadID();
   ...
}