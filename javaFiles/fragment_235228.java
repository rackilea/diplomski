ServerSocket clientConnect = new ServerSocket(port);
System.out.println("SimpleServer running on port" + port);

Socket clientSock = clientConnect.accept();
try {
  ObjectInputStream stream = new ObjectInputStream(clientSock.getInputStream());
  String[][] songs = (String[][]) stream.readObject();
} finally {
  clientSock.close();
}