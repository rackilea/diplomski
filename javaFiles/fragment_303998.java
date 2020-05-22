public AcceptThread extends Thread {
  public void run() {
    ServerSocket ss = new ServerSocket(4646);
    while (true) {
      Socket newConnection = ss.accept();
      ClientThread thread = new ClientThread(newConnection);
      thread.start();
    }
  }
}