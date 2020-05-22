import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JFrame;

public class DisplayStuff {

   public static void main(String[] args) {

      class TimerListener implements ActionListener {
         public void actionPerformed(ActionEvent event) {
            System.out.println("Display me.");
         }
      }

      ActionListener listener = new TimerListener();
      Timer t = new Timer(1000, listener);
      t.start();

      // ***** add just this *****
      JOptionPane.showMessageDialog(null, "foo");

   }
}