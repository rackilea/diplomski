public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    List<Future<?>> list = new ArrayList<Future<?>>();

    for (int i = 0; i < 5; i++) {
        ThreadTask task = new ThreadTask();
        task.setTaskName("task_" + i);
        Future<?> future = executor.submit(task);
        list.add(future);
    }
    for (Future<?> f : list) {
        if (!f.isDone()) {
            System.out.println("Running thread terminating");
            f.cancel(true);
        }
    }
    for (Future<?> f : list) {
        if (f.isDone()) {
            System.out.println("Running thread terminated");
        }
    }
    executor.shutdown();
    System.out.println("Program Completed");
}