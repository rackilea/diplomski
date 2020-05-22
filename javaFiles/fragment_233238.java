if (args.length != 2) {
  System.out.println("Tests the ThreadPool task.");
  System.out
      .println("Usage: java ThreadPoolTest numTasks numThreads");
  System.out.println("  numTasks - integer: number of task to run.");
  System.out.println("  numThreads - integer: number of threads "
      + "in the thread pool.");
  return;
}