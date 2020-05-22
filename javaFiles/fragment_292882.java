public class TCPListener {

    public TCPListener(int portNumber) {
            try {
                serverSocket = new ServerSocket(portNumber);
            } catch (IOException e) {
                System.out.println("Could not listen on port: " + portNumber);
            }
            System.out.println("TCPListener created!");
                    System.out.println("Connection accepted");
            try {
                while (true) {
                    Socket clientConnection = serverSocket.accept();

    //every time client's class constructor called - line above will be executed and new connection saved into Socket class.
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }