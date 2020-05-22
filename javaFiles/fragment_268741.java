private static Thread acception = new Thread("Acception Thread") {

    public void run() {

        try {
            while (true) {
                System.out.println("Waiting for Connection");
                new EchoServer2(serverSocket.accept());
            }
    ->  } catch (SocketException e) {
    ->      if(serverSocket.isClosed())
    ->          System.out.println("Connection Closed.");
    ->  }
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

    }
};