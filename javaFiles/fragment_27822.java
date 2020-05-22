import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Foo002 {

   public static void main(String[] args) {
      final JFrame f = new JFrame();
      f.setLayout(new BorderLayout());
      f.setSize(400, 400);
      JButton b = new JButton("B1");
      f.add(b, BorderLayout.CENTER);
      b.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new SwingWorker() {

               @Override
               protected Object doInBackground() throws Exception {
                  Thread current = Thread.currentThread();
                  System.out.printf("ID: %d, Name: %s%n", current.getId(), current.getName());
                  System.out.println("Active Count: " + Thread.activeCount());
                  return null;
               }
            }.execute();
         }
      });

      f.setVisible(true);
   }
}