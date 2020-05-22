import javax.swing.*;
  import java.io.IOException;

  /**
     * Created by Алексей on 24.11.2016.
   */
 public class Main {

public static void main(String[] args) throws IOException {

    displayImage();
}

public static void displayImage() throws IOException {
    JFrame frame = new JFrame("frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);

    JLabel imgLabel = new JLabel(new ImageIcon("src/url-2.jpg"));

    frame.add(imgLabel);

    frame.setVisible(true);
}
}