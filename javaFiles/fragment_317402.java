Task task = new Task<Void>() {
  @Override
  public Void call() throws Exception {
    int i = 0;
    while (true) {
      final int finalI = i;
      Platform.runLater(new Runnable() {
        @Override
        public void run() {
          label.setText("" + finalI);
        }
      });
      i++;
      Thread.sleep(1000);
    }
  }
};
Thread th = new Thread(task);
th.setDaemon(true);
th.start();