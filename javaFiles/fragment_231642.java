public void ExecuteTask(MyRunnableTask task) {
    bool taskAdded = false;
    while(!taskAdded) {
        try {
            executor.execute(task);
            taskAdded = true;
        } catch (RejectedExecutionException ex) {
            taskAdded = false;
        }
    }   
}