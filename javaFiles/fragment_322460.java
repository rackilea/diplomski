import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class MyProg2 extends JPanel {
   public static final String TIMER_COMPLETE = "timer complete";
   private static final int TIMER_DELAY = 1000;
   private Timer timer;
   public MyProg2() {
      // TODO create GUI
   }

   public void playNotes() {
      if (timer != null && timer.isRunning()) {
         return;
      }
      timer = new Timer(TIMER_DELAY, new TimerListener());
      timer.start();
   }

   private class TimerListener implements ActionListener {
      private int i = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println("Auto-played note.");
         i++;
         if (i == 2) {
            timer.stop();
            firePropertyChange(TIMER_COMPLETE, false, true);
         }
      }
   }

   private static void createAndShowGui() {
      System.out.println("Starting program");
      MyProg2 mainPanel = new MyProg2();
      mainPanel.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (MyProg2.TIMER_COMPLETE.equals(pcEvt.getPropertyName()) && pcEvt.getNewValue() == Boolean.TRUE) {
               System.out.println("Your turn");
            }
         }
      });
      mainPanel.playNotes();

      JFrame frame = new JFrame("MyProg2");
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