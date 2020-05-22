import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ProgressDemo extends JPanel {
   private JProgressBar progressBar = new JProgressBar(0, 100);
   private Task task;
   boolean done = false;

   public ProgressDemo() {
      progressBar.setStringPainted(true);
      progressBar.setIndeterminate(true);
      add(progressBar);
   }

   class Task extends SwingWorker<Void, Void> {
      @Override
      public Void doInBackground() {
         Random random = new Random();
         int progress = 0;
         setProgress(0);
         while (progress < 100) {
            try {
               Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignore) {
            }
            progress += random.nextInt(10);
            setProgress(Math.min(progress, 100));
         }
         return null;
      }

      @Override
      public void done() {
         done = true;
      }
   }

   private class TaskListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if ("progress".equals(evt.getPropertyName())) {
            int progress = task.getProgress();
            progressBar.setIndeterminate(false);
            progressBar.setString(null);
            progressBar.setValue(progress);
         }
         if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
            // always need to know when the SW is done
            // so we can call get() and trap exceptions
            try {
               task.get();
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            }
         }
      }
   }

   // I want to make a method here, so that it can be called when ever I want
   public void executeTask() {
      task = new Task();
      task.addPropertyChangeListener(new TaskListener());
      task.execute();
   }

   public static void main(String[] args) {
      JFrame mainScreen = new JFrame();
      mainScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      final ProgressDemo demoPanel = new ProgressDemo();

      mainScreen.getContentPane().add(demoPanel);
      mainScreen.pack();
      mainScreen.setLocationByPlatform(true);
      mainScreen.setVisible(true);

      // just for yucks, let's wait 3 seconds before calling executeTask()
      int delay = 3 * 1000;
      new Timer(delay, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            demoPanel.executeTask();

            // stop timer
            ((Timer) e.getSource()).stop();
         }
      }).start();
   }
}