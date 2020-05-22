import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Server {

    private static final int PORT = 9999;

    public static void main(String[] args) {

        System.out.println("Opening port…\n");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                ;
                try {
                    System.out.println("Waiting for connection");
                    Socket connection = serverSocket.accept();

                    System.out.println("Read image...");
                    ImageIcon icon = new ImageIcon(ImageIO.read(Server.class.getResource("/images/29bd6417998561.5635a605ad357.png")));

                    System.out.println("Read image...");
                    try (ObjectOutputStream outStream = new ObjectOutputStream(connection.getOutputStream())) {
                        System.out.println("Write image");
                        outStream.writeObject(icon);
                    }
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
        } catch (IOException ioEx) {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
    }
}