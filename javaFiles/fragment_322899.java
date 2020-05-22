import java.io.IOException;
import java.io.ObjectInputStream;

import java.net.Socket;

public class ResponseThread extends Thread {

    private final Socket socket;

    /**
     * Client is a selfmade interface which has no direct connection to socket communication.
     * i build it to provide start(), stop() and isRunning() methods.
     */
    private final Client client;
    /**
     * @param client encapsulated methods to check and manage the client status itself.
     * @param socket the socket which is connected to the server.
     */
    public ResponseThread(final Client client, final Socket socket) {
        this.client = client;
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream reader  = null;
        try(ObjectInputStream reader = new ObjectInputStream(socket.getInputStream())) {
            while (client.isRunning()) {
                try {
                    // The thread will wait here until the server sends data.
                    final String line = (String) reader.readObject();
                    if (null == line || line.isEmpty()) {
                        client.stop();
                    } else {
                        System.out.println(line);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    client.stop();
                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR Abort reading. Could not establish InputStream from Socket.");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("FATAL Could not close Socket.InputStream.");
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}