import org.junit.Test;    
import java.io.*;
import java.net.*;    
import static java.lang.System.*;

public class ServerSocketTest {

    /**
     * Runs first to start server. This is the corrected server
     */
    @Test
    public void startServerTest() throws Exception {
        ServerSocket listener = new ServerSocket(4444);
        while (true) {
            try (Socket socket = listener.accept()) {
                new PrintWriter(socket.getOutputStream(), true).println("Connected");
                new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();//read "ALL" from client
                new ObjectOutputStream(socket.getOutputStream()).writeObject("String Object");
            }
        }
    }

    /**
     * Run client Twice to see error
     */
    @Test
    public void startClientTest() throws Exception {
        Socket s = new Socket("127.0.0.1", 4444);
        out.println(new BufferedReader(new InputStreamReader(s.getInputStream())).readLine());
        new PrintWriter(s.getOutputStream(), true).println("ALL");//tell server we want all the data
        out.println(new ObjectInputStream(s.getInputStream()).readObject());
    }

    /**
     * This implementation will error out on second test
     */
    @Test
    public void errorServerTest() throws Exception {
        ServerSocket listener = new ServerSocket(4444);
        while (true) {
            try (Socket socket = listener.accept()) {
                new PrintWriter(socket.getOutputStream(), true).println("Connected");
                /*
                * Issue is here. The sequence of object construction matters.
                * The Constructor has side effects. To correct, move this contructor below InputStreamReader.
                * */
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();//read "ALL" from client
                objectOutputStream.writeObject("String Object");
            }
        }
    }
}