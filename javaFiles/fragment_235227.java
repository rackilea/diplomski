Socket socket = new Socket("127.0.0.1", 3000);
try {
  ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());   
  oo.writeObject(mp3dataStrings);
  oo.close();
} finally {
  socket.close();
}