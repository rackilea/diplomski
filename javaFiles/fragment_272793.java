Task<Void> executeAppTask = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        Process p = Runtime.getRuntime().exec(application);
        p.waitFor();
    }
};

executeAppTask.setOnSucceeded(e -> {
    /* code to execute when task completes normally */
});

executeAppTask.setOnFailed(e -> {
    Throwable problem = executeAppTask.getException();
    /* code to execute if task throws exception */
});

executeAppTask.setOnCancelled(e -> {
    /* task was cancelled */
});

Thread thread = new Thread(executeAppTask);
thread.start();