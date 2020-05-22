import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PackTest {

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

   public static void createAndShowGui() {
      final JFrame f = new JFrame();
      final JPanel panel = new JPanel() {
         int i = 0;

         @Override
         public Dimension getPreferredSize() {
            System.out.println("getPreferredSize() called");
            if (i++ >= 2)
               return new Dimension(200, 200); // This is never returned
            else
               return new Dimension(100, 100);
         }
      };
      f.add(panel);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.pack();
      f.setVisible(true);

      int delay = 1000;
      new Timer(delay, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("Calling pack()");
            panel.revalidate();
            f.pack();
         }
      }).start();
   }
}