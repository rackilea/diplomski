import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class PausingExecution extends JPanel {
   private static final String SELECTED_TEXT = "Snafus are Better!!!";
   private static final String UNSELECTED_TEXT = "Fubars Rule!!";
   private static final String TIMES_UP = "Time's Up!!!!";
   private static final int TIMER_DELAY = 10 * 1000;

   private JTextField messageField = new JTextField(UNSELECTED_TEXT, 10);
   private JCheckBox checkBox = new JCheckBox("Click Me");

   public PausingExecution() {
      add(messageField);
      add(checkBox);

      checkBox.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent iEvt) {
            if (iEvt.getStateChange() == ItemEvent.SELECTED) {
               messageField.setText(SELECTED_TEXT);
            } else {
               messageField.setText(UNSELECTED_TEXT);
            }
         }
      });

      Timer mySwingTimer = new Timer(TIMER_DELAY, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            messageField.setText(TIMES_UP);
            checkBox.setEnabled(false);
         }
      });

      mySwingTimer.setRepeats(false);
      mySwingTimer.start();
   }

   private static void createAndShowGui() {
      PausingExecution mainPanel = new PausingExecution();

      JFrame frame = new JFrame("PausingExecution");
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