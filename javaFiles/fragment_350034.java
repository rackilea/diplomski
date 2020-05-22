Socket s = serverSocket.accept();
ClientConnection temp = new ClientConnection(s); //Changed this line
connectedClients.add(temp);
System.out.println("Client connection caught and initialized. Client: " + s);
System.out.println("Connection with " + s + " now listening for incoming packets.");
ThreadAction(temp);
CleanClientList();