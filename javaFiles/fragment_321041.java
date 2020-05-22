class UpdateLogTask extends Task<String> { // a Task<T> has a call() method returning a T
    private final String currentLog ;
    private final String message ;
    public UpdateLogTask(String currentLog, String message) {
      this.currentLog = currentLog ;
      this.message = message ;
    }
    @Override
    public String call() throws Exception {
      String[] lines = currentLog.split("\r\n");
      StringBuilder text = new StringBuilder();
      for (int i=0; i<lines.length; i++) {
        if (i>=200 || lines.length < 200) {
          text.append(lines[i]);
        }
      }
      text.append(message).append("\r\n");
      return text.toString() ;
    }
}
final Task<String> updateLogTask = new UpdateLogTask(outputLog.getText(), message);
updateLogTask.setOnSucceeded(new EventHandler<WorkerStateEvenet>() {
    @Override
    public void handle(WorkerStateEvent event) {
      outputLog.setText(updateLogTask.getValue());
    }
});
Thread t = new Thread(updateLogTask);
t.setDaemon(true); // will terminate if JavaFX runtime terminates
t.start();