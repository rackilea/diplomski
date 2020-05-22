scene.setCursor(Cursor.WAIT);
Task<Void> task = new Task<Void>() {
    @Override
    public Void call() {
        // long running task here...
        return null ;
    }
};
task.setOnSucceeded(e -> scene.setCursor(Cursor.DEFAULT));
new Thread(task).start();