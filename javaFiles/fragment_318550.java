ExecutorService executor = Executors.newFixedThreadPool(5);

for(int i=0; i<10; i++){
    ThreadTask task = new ThreadTask();
    task.setTaskName("task_"+i);
    executor.execute(task);

    if (some condition) {
        executor.shutdown();
    }
}