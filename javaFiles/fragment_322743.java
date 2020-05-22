import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Client {

    private InetAddress host;
    private final int PORT = 9999;
    private ImageIcon image;
    private JLabel label;

    public static void main(String[] args) {

        Client pictureFrame = new Client();
    }

    public Client() {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException uhEx) {

            System.out.println("Host ID not found!");
            System.exit(1);
        }

        JFrame frame = new JFrame();
        label = new JLabel();
        frame.add(label);

        System.out.println("Connect to server");
        try (Socket connection = new Socket(host, PORT)) {
            try (ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream())) {
                System.out.println("Read image");
                image = (ImageIcon) inStream.readObject();
                label.setIcon(image);
                System.out.println("All done");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}