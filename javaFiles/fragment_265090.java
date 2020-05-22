ServerSocket server = new ServerSocket(3000);

while(true){
    Socket socket = server.accept();
    socket.close();
}