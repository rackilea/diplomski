import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class ClosingDialogPanel {
   private JPanel mainPanel = new JPanel();
   private JProgressBar progressBar = new JProgressBar();
   private JDialog dialog;
   private MyWorker myWorker;

   public ClosingDialogPanel(Window win, int minimum, int maximum, String title) {
      myWorker = new MyWorker(minimum, maximum);
      progressBar.setMinimum(minimum);
      progressBar.setMaximum(maximum);
      myWorker.addPropertyChangeListener(new WorkerListener());
      progressBar.setStringPainted(true);
      mainPanel.add(progressBar);
      dialog = new JDialog(win, title, ModalityType.APPLICATION_MODAL);
      dialog.add(mainPanel);
      dialog.pack();
      dialog.setLocationRelativeTo(win);
   }

   public void displayDialog() {
      myWorker.execute();
      dialog.setVisible(true);
   }

   private class WorkerListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (MyWorker.VALUE.equals(evt.getPropertyName())) {
            progressBar.setValue(myWorker.getValue());
         }
         if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
            if (dialog != null && dialog.isVisible()) {
               dialog.dispose();
            }
            try {
               myWorker.get();
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
      }
   }

   private static void createAndShowGui() {
      final JFrame frame = new JFrame("Closing Frame");

      JButton closeBtn = new JButton(new AbstractAction("Close") {

         @Override
         public void actionPerformed(ActionEvent e) {
            final ClosingDialogPanel closingDlg = new ClosingDialogPanel(frame, 0,
                  200, "Closing");
            closingDlg.displayDialog();
         }
      });

      JPanel panel = new JPanel();
      panel.add(closeBtn);

      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(panel);
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

class MyWorker extends SwingWorker<Void, Void> {
   public static final String VALUE = "value";
   private int value;
   private int minimum;
   private int maximum;

   public MyWorker(int minimum, int maximum) {
      this.minimum = minimum;
      this.maximum = maximum;
      value = minimum;
   }

   @Override
   protected Void doInBackground() throws Exception {
      for (int i = minimum; i <= maximum; i++) {
         setValue(i);
         Thread.sleep(30);
      }
      return null;
   }

   private void setValue(int i) {
      int oldValue = this.value;
      int newValue = i;
      this.value = i;
      firePropertyChange(VALUE, oldValue, newValue);
   }

   public int getValue() {
      return value;
   }
}