import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

public class Test2 extends JApplet {


   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               Test2BPanel panel = new Test2BPanel();
               setContentPane(panel);
            }
         });
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

   }


}

class Test2BPanel extends JPanel {
   private String[] backgroundImageFileNames = { "test", "test", "test" };

   private JButton refreshButton;
   private JComboBox backgroundList;

   public Test2BPanel() {

      setBackground(Color.white);

      setLayout(new FlowLayout());

      refreshButton = new JButton("replant new forest");
      refreshButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }

      });
      add(refreshButton);

      backgroundList = new JComboBox(backgroundImageFileNames);
      backgroundList.setSelectedIndex(2);
      add(backgroundList);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      paintIt(g);
   }

   public void paintIt(Graphics g) {
      for (int i = 0; i < 200; i++) {
         for (int j = 0; j < 200; j++) {
            g.setColor(Color.red);
            g.drawOval(10 * i, j, 10, 10);
         }
      }
   }
}