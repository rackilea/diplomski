public class Server {

      // this class represents an instance of a client connection to this server
      // It's an object that keeps track of the socket created by
      // the connection and it runs in a separate thread to not block
      // the main method thread on this server.
      private class ClientInstanceOnTheServer extends Thread {

        private Socket connectionToClient;

        public ClientInstanceOnTheServer(Socket connectionToClient) {
          this.connectionToClient = connectionToClient;
        }

        private void logicToServeAClient() {
          // here goes the logic that serves a client
        }

        public void run () {

          try {
            logicToServeAClient();
          } finally {
            try {
              socket.close();
            } catch (IOException e) {// handle exceptions!}
          }

        }

      }

      public static void main(String [] args) {
        try {
          ServerSocket serverSocket = new ServerSocket(1299);
          while (true) { // run indefinitely
             Socket socket = serverSocket.accept(); // accept connections from clients
             // keep track of the socket object as it represents a connection to a client
             // the server is responsible for keeping track of its connections to clients
             // and it should use a separate thread for each client to not block the main method thread.
             // Example:
             ClientInstanceOnTheServer client = new ClientInstanceOnTheServer(socket);
             client.start(); // this will execute the run method in ClientInstanceOnTheServer class.
          }
        } finally {
          serverSocket.close();
        }
      }
    }