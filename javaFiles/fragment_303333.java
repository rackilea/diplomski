import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChangeButton extends JPanel {
   private int buttonCount = 1;
   private JButton button = new JButton();

   public ChangeButton() {
      add(button);
      button.setText(makeButtonText());

      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton btn = (JButton) evt.getSource();
            btn.setText(makeButtonText());
         }
      });
   }

   private String makeButtonText() {
      String buttonText = "Process number " + buttonCount;
      buttonCount++;
      return buttonText;
   }

   private static void createAndShowGui() {
      ChangeButton mainPanel = new ChangeButton();

      JFrame frame = new JFrame("ChangeButton");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}