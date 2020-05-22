public Client(PApplet parent, String host, int port) {
    ...
    try {
      socket = new Socket(this.host, this.port);
      ...
    } catch (IOException e) {
      e.printStackTrace();
      ...
    }
}