import java.awt.event.*;
import java.beans.*;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class Foo3 extends JPanel {
   private static final String DEFAULT_SPEED = "15";
   private JTextField speedTextField = new JTextField(DEFAULT_SPEED, 5);
   private JProgressBar someProgressBar = new JProgressBar();
   private RunAction runAction = new RunAction();
   private JButton runButton = new JButton(runAction);

   public Foo3() {
      speedTextField.setAction(runAction);

      add(new JLabel("Speed:"));
      add(speedTextField);
      add(someProgressBar);
      add(runButton);
   }

   public void myRun() {
      String speedText = speedTextField.getText();
      try {
         int speed = Integer.parseInt(speedText);
         final BulkProcessor bulkProcessor = new BulkProcessor(speed);
         bulkProcessor.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pcEvt) {
               if (pcEvt.getPropertyName().equals("progress")) {
                  int progress = bulkProcessor.getProgress();
                  someProgressBar.setValue(progress);
               }
               if (pcEvt.getPropertyName().equals("state")) {
                  if (bulkProcessor.getState().equals(
                        SwingWorker.StateValue.DONE)) {
                     someProgressBar.setValue(0);
                     setGuiEnabled(true);
                  }
               }
            }
         });
         setGuiEnabled(false);
         bulkProcessor.execute();
      } catch (NumberFormatException e) {
         String text = "Speed of " + speedTextField.getText()
               + " is invalid. Please enter an integer";

         JOptionPane.showMessageDialog(this, text, "Invalid Speed Value",
               JOptionPane.ERROR_MESSAGE);
         speedTextField.setText(DEFAULT_SPEED);
      }
   }

   private class RunAction extends AbstractAction {
      public RunAction() {
         super("Run");
         putValue(MNEMONIC_KEY, KeyEvent.VK_R);
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         myRun();
      }

   }

   private void setGuiEnabled(boolean enabled) {
      runButton.setEnabled(enabled);
      speedTextField.setEnabled(enabled);
   }

   private static void createAndShowGui() {
      Foo3 mainPanel = new Foo3();

      JFrame frame = new JFrame("Foo3");
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

class BulkProcessor extends SwingWorker<Void, Void> {
   private Random random = new Random(); // just for SSCCE sake
   private int speed;

   public BulkProcessor(int speed) {
      this.speed = speed;
   }

   @Override
   protected Void doInBackground() throws Exception {
      int progress = 0;
      while (progress <= 100) {
         progress += random.nextInt(speed);
         setProgress(progress);
         Thread.sleep(300);
      }
      return null;
   }

}