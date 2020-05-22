ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
...
File receivedFile = null;
try {
    receivedFile = (File) in.readObject();
}
catch (IOException e) {
...
}