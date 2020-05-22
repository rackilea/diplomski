import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Convert extends AbstractAction {
   private static final long SLEEP_TIME = 3000; // 3 seconds
   private String enabledText;
   private String disabledText;

   public Convert(String enabledText, String disabledText) {
      super(enabledText);
      this.enabledText = enabledText;
      this.disabledText = disabledText;
   }

   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
      if (!(source instanceof JButton)) {
         return;
      }
      final JButton button = (JButton) source;
      setButtonEnabled(button, false);
      new SwingWorker<Void, Void>() {
         @Override
         protected Void doInBackground() throws Exception {
            // TODO: long-running code goes here. 
            // Emulated by Thread.sleep(...) 
            Thread.sleep(SLEEP_TIME);
            return null;
         }

         @Override
         protected void done() {
            setButtonEnabled(button, true);
         }
      }.execute();
   }

   public void setButtonEnabled(JButton button, boolean enabled) {
      if (enabled) {
         button.setText(enabledText);
         button.setEnabled(true);
      } else {
         button.setText(disabledText);
         button.setEnabled(false);
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("Convert");
      frame.getContentPane().add(new ConvertGui());
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

@SuppressWarnings("serial")
class ConvertGui extends JPanel {
   public ConvertGui() {
      add(new JButton(new Convert("GO", "Working...")));
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(300, 200);
   }
}