private class MySwingWorker extends SwingWorker<Void, String> {
  private byte[] buffer = new byte[2000];

  @Override
  protected Void doInBackground() throws Exception {
     while (true) {
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(incoming);

        String incomingMessage = new String(incoming.getData());
        publish(incomingMessage);
     }
     return null;
  }

  @Override
  protected void process(List<String> chunks) {
     for (String chunk : chunks) {
        textArea.append("Client: " + chunk + "\n");
     }
  }
}