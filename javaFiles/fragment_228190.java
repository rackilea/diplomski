import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.NumberFormat;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.event.IIOWriteProgressListener;

public class Server {

    public static void main(String args[]) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6789);

            while (true) {
                System.out.println("Get next client...");
                Socket skt = welcomeSocket.accept();
                // Hand of the processing to the socket handler...
                new Thread(new SocketHandler(skt)).start();
            }
        } catch (IOException ex) {
        }
    }

    // Reads a request from the client
    // All requests must be terminated with a new line (\n)
    protected static String readRequest(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder(128);
        int in = -1;
        while ((in = is.read()) != '\n') {
            sb.append((char) in);
        }
        return sb.toString();
    }

    // Grabs the screen shot and writes to the supplied output stream
    // This will first write the byte size of the following byte array and
    // writes the byte array of the image.  Clients should expect a 
    // int value terminated by a new line character (\n)
    protected static void grabScreen(OutputStream os) throws AWTException, IOException {
        System.out.println("Grab screen shot");
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        System.out.println("Writing image to buffer...");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(capture, "jpg", baos);
        baos.close();
        System.out.println("Write byte size = " + baos.size());
        os.write((Integer.toString(baos.size()) + "\n").getBytes());
        System.out.println("Write byte stream");
        os.write(baos.toByteArray());
        System.out.println("Image sent");
    }

    // Handler for an individual client socket...
    public static class SocketHandler implements Runnable {

        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String request = null;
            InputStream is = null;
            OutputStream os = null;
            try {
                System.out.println("Processing client requests");
                is = socket.getInputStream();
                os = socket.getOutputStream();
                do {
                    System.out.println("Waiting for next request");
                    request = readRequest(is);
                    System.out.println("Request = " + request);
                    if ("grab".equalsIgnoreCase(request)) {
                        grabScreen(os);
                    }
                } while (!"done".equalsIgnoreCase(request) && !"shutdown".equalsIgnoreCase(request));
                System.out.println("Client has closed");
            } catch (IOException | AWTException exp) {
                exp.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {
                }
            }
            // Special command to stop the server...
            if ("shutdown".equalsIgnoreCase(request)) {
                System.exit(0);
            }
        }
    }
}