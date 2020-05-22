Thread queryThread = new Thread() {
  public void run() {
    new game();
  }
};
queryThread.start();