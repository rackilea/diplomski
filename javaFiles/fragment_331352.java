ExampleTask.TaskListener listener = new ExampleTask.TaskListener() {
    @Override
    public void onFinished(String result) {
        // Do Something after the task has finished
    }
};

ExampleTask task = new ExampleTask(listener);    
task.execute();