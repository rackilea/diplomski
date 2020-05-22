ServerSocket serverSocket = new ServerSocket(8080);
while (true) {
  Socket socket = serverSocket.accept();
  DataInputStream din = new DataInputStream(socket.getInputStream());      
  System.out.println(din.readInt());              
  socket.close();
}