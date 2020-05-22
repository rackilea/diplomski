import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyButtonGroupTest {
   private static void createAndShowUI() {
      String[] data = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

      JPanel panel = new JPanel(new GridLayout(0, 1));
      MyButtonGroup myBtnGrp = new MyButtonGroup();
      myBtnGrp.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.out.println("Action Command is: " + e.getActionCommand());
         }
      });

      for (String text : data) {
         JRadioButton radioBtn = new JRadioButton(text);
         radioBtn.setActionCommand(text);
         myBtnGrp.add(radioBtn);
         panel.add(radioBtn);
      }

      JFrame frame = new JFrame("MyButtonGroupTest");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}