import java.awt.Dimension;
import java.awt.Window;

import javax.swing.*;

public class Foo {
   public static void main(String[] args) {
      JPanel panel = new JPanel(new BorderLayout(5, 5));
      panel.add(Box.createRigidArea(new Dimension(400, 300)));

      Window window = null;
      if (Math.random() < 0.5) {
         window = new JDialog();
         ((JDialog) window).setTitle("Dialog");
      } else {
         window = new JFrame();
         ((JFrame)window).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ((JFrame)window).setTitle("Frame");
      }     

      window.add(panel);
      window.pack();
      window.setLocationRelativeTo(null);
      window.setVisible(true);
   }
}