serverSocket = new ServerSocket(localhost:8888)
if success, 
    start ServerSocketListeningThread
else
    socket = new Socket(localhost:8888)
    socket.close();
    sleep(100);
    repeat attempt of binding server socket

ServerSocketListeningThread
    serverSocket.accept();  //block until someone connects
    System.exit();