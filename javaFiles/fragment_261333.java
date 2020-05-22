import java.awt.*;
import javax.swing.*;

public class GridPrb {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container cp = frame.getContentPane();
    cp.setLayout(new GridLayout(5, 5));

    for(int y = 0; y < 5; y++) {
      for(int x = 0; x < 5; x++) {
        Label l = new Label("x=" + x + ",y=" + y);
        cp.add(l);
      }
    }
    frame.pack();
    frame.setVisible(true);
  }
}