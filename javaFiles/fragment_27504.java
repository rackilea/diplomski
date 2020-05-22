private class ClientThread extends Thread {
  private Socket socket;

  // The queue, thread-safe for good measure
  private Queue<String> queue = new ConcurrentLinkedQueue<String>();

  public ClientThread(Socket socket) throws IOException {
    this.socket = socket;
  }

  public void send(String message) {
    if (message != null) {
      this.sendQueue.add(message);
    }
  }

  public void run() {
    try {
      connection = socket;
      output = new ObjectOutputStream(socket.getOutputStream());
      output.flush();
      input = new ObjectInputStream(socket.getInputStream());
      displayMessage("Got I/O Stream\n");
      displayMessage("Connection " + counter + " received from: " 
          + connection.getInetAddress().getHostName());
      counter++;
      String message = "Connection Sucessful";
      sendData(message);
      setTextFieldEditable(true);
      do {
        // Purge the queue and send all messages.
        while ((String msg = queue.poll()) != null) {
          sendData(msg);
        }
        message = (String) input.readObject();
        displayMessage("\n" + message);
      } while (!message.endsWith(">>> TERMINATE"));
    } catch (ClassNotFoundException classNotFoundException) {
      displayMessage("\nUnknown object type recieved");
    } finally {
      closeConnection();
    }
  }
}