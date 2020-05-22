Socket clientSocket = null;
    try {
        clientSocket = server.accept();
        System.out.println("Connected from " + clientSocket .getInetAddress() + " on port "
             + clientSocket .getPort() + " to port " + clientSocket .getLocalPort() + " of "
             + clientSocket .getLocalAddress());
    } catch (IOException e) {
        System.exit(1);
    }