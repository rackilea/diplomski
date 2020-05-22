import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class TimerTest {
   private static final int TIMER_DELAY = 20;

   private static void createAndShowGui() {
      MyGui myGui = new MyGui();
      TimerListener timerListener = new TimerListener(myGui, 2 * 60 * 1000);
      new Timer(TIMER_DELAY, timerListener).start();
      JFrame frame = new JFrame("TimerTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(myGui.getMainComponent());
      frame.pack();
      frame.setLocationRelativeTo(null);
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

class MyGui {
   private static final int PREF_W = 200;
   private static final int PREF_H = 80;
   private JPanel mainPanel = new JPanel() {
      public Dimension getPreferredSize() {
         return MyGui.this.getPreferredSize();
      };
   };
   private JLabel statusLabel = new JLabel();

   public MyGui() {
      mainPanel.add(statusLabel);
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void setStatus(String text) {
      statusLabel.setText(text);
   }
}

class TimerListener implements ActionListener {
   private static final String FORMAT = "Count Down: %02d:%02d:%03d";
   private static final int MS_PER_SEC = 1000;
   private static final int SEC_PER_MIN = 60;
   private MyGui myGui;
   private long countDownTime;
   private long startTime;

   public TimerListener(MyGui myGui, long countDownTime) {
      this.myGui = myGui;
      this.countDownTime = countDownTime;
      startTime = System.currentTimeMillis();
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      long currentTime = System.currentTimeMillis();
      long deltaTime = countDownTime - (currentTime - startTime);
      if (deltaTime < 0) {
         ((Timer) evt.getSource()).stop();
         deltaTime = 0;
      }
      int minutes = (int) (deltaTime / (MS_PER_SEC * SEC_PER_MIN));
      deltaTime = deltaTime % (MS_PER_SEC * SEC_PER_MIN);
      int seconds = (int) (deltaTime / MS_PER_SEC);
      deltaTime = deltaTime % MS_PER_SEC;
      int msecs = (int) deltaTime;
      String text = String.format(FORMAT, minutes, seconds, msecs);
      myGui.setStatus(text);
   }
}