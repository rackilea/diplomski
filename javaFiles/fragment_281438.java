import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class ScanFileFrame {
   private FileScanAction fileScanAction = new FileScanAction("Scan Files", KeyEvent.VK_S);
   private JButton btnTicking = new JButton(fileScanAction);
   private JLabel label1;
   private MyFileScanWorker worker;

   ScanFileFrame() {

      JFrame jframe = new JFrame();
      jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jframe.setLayout(new FlowLayout());
      label1 = new JLabel("       No File Scanned       ", SwingConstants.CENTER);

      jframe.add(btnTicking);
      jframe.add(label1);
      jframe.pack();
      jframe.setLocationByPlatform(true);
      jframe.setVisible(true);

   }

   @SuppressWarnings("serial")
   private class FileScanAction extends AbstractAction {
      public FileScanAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         label1.setText("Scanning Files");
         fileScanAction.setEnabled(false);
         worker = new MyFileScanWorker();
         worker.addPropertyChangeListener(new WorkerListener());
         worker.execute();
      }
   }

   private class WorkerListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent pcEvt) {
         if (pcEvt.getNewValue() == SwingWorker.StateValue.DONE) {
            fileScanAction.setEnabled(true);
            try {
               boolean success = worker.get();
               String text = success ? "Scanning Successful" : "Scanning Error";
               label1.setText(text);
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            }
         }
      }
   }

   private class MyFileScanWorker extends SwingWorker<Boolean, Void> {

      @Override
      protected Boolean doInBackground() throws Exception {
         // Simulate scan file
         Thread.sleep(2000);

         // have it work successfully 2/3 of the time.
         if (Math.random() > 0.3333) {
            return true;
         } else {
            return false;
         }
      }
   };

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new ScanFileFrame();
         }
      });
   }
}