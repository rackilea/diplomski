import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class StopThreadGui extends JPanel {
   private JTextField field1 = new JTextField("Hello", 10);
   private JTextField field2 = new JTextField("Goodbye", 10);
   private JButton startButton = new JButton(new StartAction("Start", KeyEvent.VK_S));
   private JButton endButton = new JButton(new EndAction("End", KeyEvent.VK_E));
   private MySwingWorker myWorker;

   public StopThreadGui() {
      add(field1);
      add(field2);
      add(startButton);
      add(endButton);
   }

   private static void createAndShowGui() {
      StopThreadGui mainPanel = new StopThreadGui();

      JFrame frame = new JFrame("StopThreadGui");
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

   private class StartAction extends AbstractAction {
      public StartAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (myWorker != null && !myWorker.isDone()) {
            return;
         }
         String text1 = field1.getText();
         String text2 = field2.getText();

         myWorker = new MySwingWorker(text1, text2);
         myWorker.execute();
      }
   }

   private class EndAction extends AbstractAction {
      public EndAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (myWorker == null || myWorker.isDone()) {
            return;
         }
         myWorker.cancel(true);
      }
   }

}

class MySwingWorker extends SwingWorker<Void, Void> {
   private static final long SLEEP_TIME = 400;
   private String text1;
   private String text2;

   public MySwingWorker(String text1, String text2) {
      this.text1 = text1;
      this.text2 = text2;
   }

   @Override
   protected Void doInBackground() throws Exception {
      boolean foo = true;
      while (foo) {
         System.out.printf("Text1: %s;   Text2: %s%n", text1, text2);
         System.out.println("Close me please..");
         Thread.sleep(SLEEP_TIME);
      }
      return null;
   }
}