Runnable r = new Runnable () {
  public void run() {
    Server.Start();
  }
}
new Thread(r).start();