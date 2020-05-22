import java.awt.event.ActionEvent;
import java.beans.*;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class PropChangeSupportEg extends JPanel {
   private MyNavigator myNavigator = new MyNavigator();
   private JTextField textField = new JTextField(10);

   public PropChangeSupportEg() {
      textField.setFocusable(false);
      add(textField);
      add(new JButton(new StartAction("Start")));
      add(new JButton(new StopAction("Stop")));
   }

   private class StartAction extends AbstractAction {
      public StartAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if (myNavigator.isUpdatingText()) {
            return; // it's already running
         }
         MyWorker worker = new MyWorker();
         worker.execute();
      }
   }

   private class StopAction extends AbstractAction {
      public StopAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         myNavigator.stop();
      }
   }

   private class MyWorker extends SwingWorker<Void, String> {
      @Override
      protected Void doInBackground() throws Exception {
         if (myNavigator.isUpdatingText()) {
            return null;
         }

         myNavigator.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
               if (MyNavigator.BOUND_PROPERTY_TEXT.equals(evt.getPropertyName())) {
                  publish(evt.getNewValue().toString());
               }
            }
         });
         myNavigator.start();
         return null;
      }

      @Override
      protected void process(List<String> chunks) {
         for (String chunk : chunks) {
            textField.setText(chunk);
         }
      }


   }

   private static void createAndShowGui() {
      PropChangeSupportEg mainPanel = new PropChangeSupportEg();

      JFrame frame = new JFrame("Prop Change Eg");
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

class MyNavigator {
   public static final String BOUND_PROPERTY_TEXT = "bound property text";
   public static final String UPDATING_TEXT = "updating text";
   private static final long SLEEP_TIME = 1000;
   private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);
   private String boundPropertyText = "";
   private String[] textArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
   private int textArrayIndex = 0;
   private volatile boolean updatingText = false;

   public void start() {
      if (updatingText) {
         return;
      }
      updatingText = true;
      while (updatingText) {
         textArrayIndex++;
         textArrayIndex %= textArray.length;
         setBoundPropertyText(textArray[textArrayIndex]);
         try {
            Thread.sleep(SLEEP_TIME);
         } catch (InterruptedException e) {}
      }
   }

   public void stop() {
      setUpdatingText(false);
   }

   public String getBoundPropertyText() {
      return boundPropertyText;
   }

   public boolean isUpdatingText() {
      return updatingText;
   }

   public void setUpdatingText(boolean updatingText) {
      boolean oldValue = this.updatingText;
      boolean newValue = updatingText;
      this.updatingText = updatingText;
      pcSupport.firePropertyChange(UPDATING_TEXT, oldValue, newValue);
   }

   public void setBoundPropertyText(String boundPropertyText) {
      String oldValue = this.boundPropertyText;
      String newValue = boundPropertyText;
      this.boundPropertyText = boundPropertyText;
      pcSupport.firePropertyChange(BOUND_PROPERTY_TEXT, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }
}