Socket socket = serverSocket.accept();

ClientThread thread = new ClientThread(socket);

class ClientThread extends Thread {
  Socket socket;

  public void run() {
    while (!closed) {
      String line = reader.readLine();
      ...
    }
  }