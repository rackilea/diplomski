while(true){
    socket = ss.accept();
    System.out.println("ChatServer Accepts!!" + new Date() );
    clients.add(socket);
    sendWelcomeMessage();
    (new Thread(new ClientHandler(socket))).start();
}