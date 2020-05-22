Socket s = serverSocket.accept();
ConnectedClient temp = new ConnectedClient(s);
connectedClients.add(temp);
System.out.println("Client connection caught and initialized. Client: " + s);
System.out.println("Connection with " + s + " now listening for incoming packets.");
ThreadAction(temp);
CleanClientList();