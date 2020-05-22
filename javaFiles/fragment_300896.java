ServerSocket serverSocket = new ServerSocket(6000);
Socket socket = serverSocket.accept();

ObjectOutputStream outputStream =
    new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());