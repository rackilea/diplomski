import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

import java.util.logging.Logger;

public class Server extends Thread {

private static ServerSocket socket;
private static String home = "./";
private static int port = 9876;
private static boolean isAlive = true;
private static final Server server = new Server();

public static Server getServer(String[] args) {
    if (args.length == 2) {
        home = args[1];
    }
    port = Integer.parseInt(args[0]);
    return server;
}

private Server() {

}

public static Server getServer() {
    return server;
}

@Override
public void run() {
    try {
        if (socket != null) {
            if (!socket.isClosed()) {
                if (port == getPort()) {
                    System.err.println("Server active at the Same Port! ");
                } else {
                    close();
                }
            }
        }
        socket = new ServerSocket(port);
        port = socket.getLocalPort();
        System.out.println("Server accepting connections on port :" + port);
        socket.setReceiveBufferSize(146988);
        handlleRequest();
    } catch (IOException e) {
        System.err.println("Could not start server: " + e.getMessage());
        port = 0;
        run();
    }
}

public int getPort() {
    return socket == null ? 0 : port;
}

public String getPortS() {
    return String.valueOf(port);
}

public void Stop() {
    isAlive = false;
}

public void handlleRequest() {
    while (isAlive) {
        System.out.println("Test");
        try (Socket connection = socket.accept()) {
            display(connection);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

public void display(Socket connection) {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        String line = in.readLine();
        while (in.ready() && line != null) {
            System.out.println(line);
            line = in.readLine();
        }
    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void close() throws IOException {
    if (socket != null && !socket.isClosed()) {
        isAlive = false;
        socket.close();
    }
}

public static void main(String[] args) {
    args = new String[]{"9876", "./"};
    Server f = Server.getServer(args);
    f.start();
}

}