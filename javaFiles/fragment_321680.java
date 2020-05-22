Thread serverThread = new Thread(new Runnable() {
  @Override
  public void run() {
    new Server();
  }
});
Thread clientThread = new Thread(new Runnable() {
  @Override
  public void run() {
    new Client();
  }
});
serverThread.start();
clientThread.start();