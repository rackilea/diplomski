import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyTimer extends JPanel {

   private JLabel timeDisplay;
   private JButton resetButton;
   private JButton startButton;
   private JButton stopButton;
   private Timer timer;

   public MyTimer() {

      startButton = new JButton("Start Timer");
      stopButton = new JButton("Stop Button");
      timeDisplay = new JLabel("...Waiting...");
      resetButton = new JButton("Reset Timer");

      this.add(resetButton);
      this.add(startButton);
      this.add(stopButton);
      this.add(timeDisplay);

   }

   private class TimerClass implements ActionListener {

      int counter;

      public TimerClass(int counter) {
         this.counter = counter;
      }

      @Override
      public void actionPerformed(ActionEvent tc) {
         counter++;
      }

   }

   private class startButtonaction implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         int count = 0;
         timeDisplay.setText("Time Elapsed in Seconds: " + count);

         TimerClass tc = new TimerClass(count);
         timer = new Timer(1000, tc);
         timer.start();
      }
   }

}