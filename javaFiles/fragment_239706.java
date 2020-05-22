import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Server {
  public static void main(String[] args) throws Exception {
    BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    try (ServerSocket serv = new ServerSocket(25000)) {
      System.out.println("waiting...");
      try (Socket socket = serv.accept()) {
        System.out.println("client connected");
        ImageIO.write(screencapture, "jpg", socket.getOutputStream());
        System.out.println("sent");
      }
    }
  }
}

class Client {
  public static void main(String[] args) throws Exception {
    try(Socket socket = new Socket("localhost", 25000)){
      BufferedImage image = ImageIO.read(socket.getInputStream());
      JLabel label = new JLabel(new ImageIcon(image));
      JFrame f = new JFrame("vnc");
      f.getContentPane().add(label);
      f.pack();
      f.setVisible(true);
    }
  }
}