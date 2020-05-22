public class Client {

public Client( String host, int port ) throws Exception {
    Socket socket = new Socket(host, port);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    DataInputStream dis = new DataInputStream(socket.getInputStream() );
    dos.writeUTF( "a line from client" );
    try {
         while( true ){
            String line = dis.readUTF();
            System.out.println( "got: " + line );
         }
    } catch( Exception e ){
    }
    dis.close();
    dos.close();
}

public static void main(String args[]) throws Exception {
    String host = args[0];
    int port = Integer.parseInt( args[1] );
    Socket socket = null;
    Client client = new Client( host, port );
}
}

public class Server {
public static void main(String[] args) throws Exception {
    int portNumber = Integer.parseInt(args[0]);

    while (true) {
        try {
            new Server(portNumber);
        } catch (java.net.SocketException se) {
        } catch (IOException ioe) {
        } catch (ClassNotFoundException cnf) {
        }
    }
}

public Server( int port ) throws Exception {
ServerSocket serverSocket = new ServerSocket(port );
    Socket socket = serverSocket.accept();

    DataInputStream dis = new DataInputStream(socket.getInputStream());
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    System.out.println("...connected...waiting for data...");
    String line = dis.readUTF();
    System.out.println( "got:" + line );
    for( int i = 1; i <= 3; i++ ){
        dos.writeUTF( "line " + i + " from server" );
    }
    dis.close();
    dos.close();
}
}