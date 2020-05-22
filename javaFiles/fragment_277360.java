import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class ServerPrintScreen
        extends Thread {

    private ServerSocket serverSocket;

    public ServerPrintScreen(int port)
            throws IOException, SQLException, ClassNotFoundException, Exception {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(0);
    }

    public void run() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Throwable localThrowable3 = null;
                try {
                    System.out.println("client connected");
                    clientSocket.setKeepAlive(true);
                    String httpResponse = "HTTP/1.1 200 OK\r\nAccess-Control-Allow-Origin: *\r\nAccept-Ranges: bytes\r\nContent-Disposition: inline;filename=screenShot.jpg\r\nContent-Type: image/jpg\r\n\r\n";
                    BufferedImage originalImage = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                    clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                    ImageIO.write(originalImage, "jpg", clientSocket.getOutputStream());
                    clientSocket.getOutputStream().flush();
                    clientSocket.getOutputStream().close();
                    clientSocket.close();
                    System.out.println("sent");
                } catch (Throwable localThrowable1) {
                    localThrowable3 = localThrowable1;
                    throw localThrowable1;
                } finally {
                    if (clientSocket != null) {
                        if (localThrowable3 != null) {
                            try {
                                clientSocket.close();
                            } catch (Throwable localThrowable2) {
                                localThrowable3.addSuppressed(localThrowable2);
                            }
                        } else {
                            clientSocket.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, Exception {
        Thread t = new ServerPrintScreen(25000);
        t.start();
    }
}