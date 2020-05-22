import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class ProgressExampleGui {
   private JPanel mainPanel = new JPanel();
   private JProgressBar progressBar = new JProgressBar();
   private JButton pressMeBtn  = new JButton(new MyAction("Press Me", KeyEvent.VK_P, this));

   public ProgressExampleGui() {
      progressBar.setStringPainted(true);
      progressBar.setString("");

      mainPanel.add(pressMeBtn);
      mainPanel.add(progressBar);
   }

   public void setProgress(int progress) {
      progressBar.setValue(progress);
      progressBar.setString(progress + "%");
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void setEnabled(boolean enabled) {
      pressMeBtn.setEnabled(enabled);
   }

   private static void createAndShowGui() {
      ProgressExampleGui progExampleGui = new ProgressExampleGui();

      JFrame frame = new JFrame("Progress Example");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(progExampleGui.getMainComponent());
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

@SuppressWarnings("serial")
class MyAction extends AbstractAction {
   private ProgressExampleGui gui;

   public MyAction(String name, int mnemonic, ProgressExampleGui gui) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      AbstractButton source = (AbstractButton) e.getSource();
      gui.setProgress(0);
      source.setEnabled(false);
      MyWorker myWorker = new MyWorker();
      myWorker.addPropertyChangeListener(new WorkerPropChngListener(gui));
      myWorker.execute();
   }
}

class WorkerPropChngListener implements PropertyChangeListener {

   private ProgressExampleGui gui;

   public WorkerPropChngListener(ProgressExampleGui gui) {
      this.gui = gui;
   }

   @Override
   public void propertyChange(PropertyChangeEvent pcEvt) {
      MyWorker myWorker = (MyWorker) pcEvt.getSource();
      if ("progress".equals(pcEvt.getPropertyName())) {
         int progress = ((Integer)pcEvt.getNewValue()).intValue();
         gui.setProgress(progress);
      }

      if (SwingWorker.StateValue.DONE.equals(pcEvt.getNewValue())) {
         try {
            myWorker.get();
         } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
         }
         gui.setEnabled(true);
      }
   }

}

class MyWorker extends SwingWorker<Void, Void> {
   private static final int MAX_INCR = 8;
   private static final long SLEEP_TIME = 200;
   private static final int MAX_VALUE = 100;
   private int value = 0;
   private Random random = new Random();

   @Override
   protected Void doInBackground() throws Exception {
      while (value < MAX_VALUE) {
         value += random.nextInt(MAX_INCR);
         value = Math.min(value, MAX_VALUE);
         Thread.sleep(SLEEP_TIME);
         setProgress(value);
      }
      return null;
   }
}