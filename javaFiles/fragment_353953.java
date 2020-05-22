Socket socket = new Socket(HOST, PORT);
int status = socket.getInputStream().read();
if (status != SERVER_READY)
    throw new Exception(String.format("Failed to connect to server %s:%s, Server is busy", HOST, PORT));
ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
....
....