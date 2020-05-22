import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Tester extends JPanel {
   public static final int TIMER_DELAY = 1000;
   public static final String TEST_TEXT = "01234567";
   private JTextField textField = new JTextField(10);
   private JButton button = new JButton(new ButtonAction());
   private Timer timer;

   public Tester() {
      add(textField);
      add(button);
   }

   private class ButtonAction extends AbstractAction {

      public ButtonAction() {
         super("Press Me");
         putValue(MNEMONIC_KEY, KeyEvent.VK_P);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if (timer != null && timer.isRunning()) {
            return;
         }
         textField.setText("");
         timer = new Timer(TIMER_DELAY, new TimerListener());
         timer.start();
      }
   }

   private class TimerListener implements ActionListener {
      private String text = "";
      private int counter = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
         text += TEST_TEXT.charAt(counter);
         textField.setText(text);
         counter++;
         if (counter >= TEST_TEXT.length()) {
            timer.stop();
         }
      }
   }

   private static void createAndShowGui() {
      Tester mainPanel = new Tester();

      JFrame frame = new JFrame("Tester");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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