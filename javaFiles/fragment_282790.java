import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;

public class CommsTest2 {

    /**
     * Starts a server or a client (depending on UI input). The server listens on http://localhost:8765/test/register and
     * http://localhost:8765/test/registerFor. The server sends back a clientID on registration and accepts 3 bytes on 'registerFor'. In
     * all cases the server sends back a 200/OK status code if all goes well.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Object startMe = JOptionPane.showInputDialog(null, "Start client or server?", "Launcher", JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Client", "Server"}, "Server");
        if (startMe.equals("Server")) {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8765), 50000);
            httpServer.setExecutor(Executors.newFixedThreadPool(20));
            httpServer.createContext("/test/" + Op.REGISTER.urlOpPath, new HttpHandler() {
                private byte clientIdCounter = 0;

                @Override
                public void handle(HttpExchange he) throws IOException {
                    System.out.println("Handling 'register' HttpExchange");
                    // 'register' sends username and accepts a byte back (the client ID)
                    try (ObjectInputStream ois = new ObjectInputStream(he.getRequestBody())) {
                        System.out.println("Processing request from user: " + ois.readUTF());
                    }
                    // send a response of code of 200, all is well! and i'm sending 1 byte back, which is the client id
                    he.sendResponseHeaders(200, 1);
                    he.getResponseBody().write(new byte[]{clientIdCounter++});
                    he.close();
                    System.out.println("Registration complete!");

                }
            });
            httpServer.createContext("/test/" + Op.REGISTER_FOR.urlOpPath, new HttpHandler() {
                @Override
                public void handle(HttpExchange he) throws IOException {
                    System.out.println("Handling 'registerFor' HttpExchange");
                    // request '1' sends 3 bytes
                    try (ObjectInputStream ois = new ObjectInputStream(he.getRequestBody())) {
                        byte clientId = ois.readByte();
                        byte opCode = ois.readByte();
                        byte argument = ois.readByte();
                        System.out.println(String.format("Received op request %d from client %d with argument %d", clientId, opCode,
                                argument));
                        // send a response code of 200, all is well! no data is being sent back though.
                        he.sendResponseHeaders(200, 0);
                    }
                    he.close();
                    System.out.println("Register-For complete!");
                }
            });
            httpServer.start();
            System.out.println("Started server @ " + httpServer.getAddress());
        } else if (startMe.equals("Client")) {
            // first phase of the connection, send a opCode of 0, send the username, receive the client id
            {
                HttpURLConnection con = create(Op.REGISTER);
                try (ObjectOutputStream oos = new ObjectOutputStream(con.getOutputStream())) {
                    oos.writeUTF(System.getProperty("user.name"));
                }
                byte clientId = (byte) con.getInputStream().read();
                System.out.println("Received ClientID: " + clientId + " and response code: " + con.getResponseCode());
                con.disconnect();
            }
            // next phase of connection, send an opCode of 1 and 3 bytes, receive nothing
            {
                HttpURLConnection con = create(Op.REGISTER_FOR);
                try (ObjectOutputStream oos = new ObjectOutputStream(con.getOutputStream())) {
                    oos.writeByte(0);
                    oos.writeByte(4);
                    oos.writeByte(2);
                }
                System.out.println("Received response code: " + con.getResponseCode());
                con.disconnect();
            }
            System.out.println("Done sending!");
        }
    }

    private static HttpURLConnection create(Op op) throws IOException {
        HttpURLConnection con = (HttpURLConnection) op.url.openConnection();
        con.setUseCaches(false);
        con.setDoInput(op.input);
        con.setDoOutput(op.output);
        return con;
    }

    private enum Op {

        REGISTER(true, true, "register"),
        REGISTER_FOR(true, true, "registerFor");
        private final boolean input, output;
        private final String urlOpPath;
        private final URL url;

        private Op(boolean input, boolean output, String opPath) {
            this.input = input;
            this.output = output;
            this.urlOpPath = opPath;
            try {
                this.url = new URL("http://localhost:8765/test/" + opPath);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}