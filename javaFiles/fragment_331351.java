ExampleTask task = new ExampleTask(new ExampleTask.TaskListener() {
    @Override
    public void onFinished(String result) {
        // Do Something after the task has finished
    }
});

task.execute();