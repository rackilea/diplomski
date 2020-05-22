Collection<YourTask> tasks = new ArrayList<YourTask>();
  YourTask yt1 = new YourTask();
  ...
  tasks.add(yt1);
  ...
  ExecutorService exec = Executors.newFixedThreadPool(5);
  List<Future<YourResultType>> results = exec.invokeAll(tasks);