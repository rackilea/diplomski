public <T, V> void executeTask(Task<T, V> task, boolean handleException) {
    task.addTaskListener(new TaskListener.Adapter<T, V>() {
        @Override
        public void failed(TaskEvent event) { /* ... */ }
    });
    getContext().getTaskService().execute(task);
}