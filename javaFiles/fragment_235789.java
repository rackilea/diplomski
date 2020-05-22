import java.awt.*;
import javax.swing.*;

public class CopyText2 {

   private static void createAndShowUI() {
      CopyTextNorthPanel2 northPanel = new CopyTextNorthPanel2();
      CopyTextSouthPanel2 southPanel = new CopyTextSouthPanel2();
      CopyTextControl2 control = new CopyTextControl2();

      southPanel.setControl(control);
      control.setNorthPanel(northPanel);
      control.setSouthPanel(southPanel);

      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(northPanel, BorderLayout.NORTH);
      mainPanel.add(Box.createRigidArea(new Dimension(100, 100)), BorderLayout.CENTER);
      mainPanel.add(southPanel, BorderLayout.SOUTH);

      JFrame frame = new JFrame("Copy Text");
      frame.getContentPane().add(mainPanel);
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