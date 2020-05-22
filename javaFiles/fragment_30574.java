import java.awt.event.*;
import javax.swing.*;

public class StopWatch extends JLabel
            implements MouseListener, ActionListener {

   private long startTime;   // Start time of stopwatch.
                             //   (Time is measured in milliseconds.)

   private boolean running;  // True when the stopwatch is running.

   private Timer timer;  // A timer that will generate events
                         // while the stopwatch is running

   public StopWatch() {
         // Constructor.
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
          // This will be called when an event from the
          // timer is received.  It just sets the stopwatch
          // to show the amount of time that it has been running.
          // Time is rounded down to the nearest second.
       long time = (System.currentTimeMillis() - startTime) / 1000;
       setText("Running:  " + time + " seconds");
   }

   public void mousePressed(MouseEvent evt) {
          // React when user presses the mouse by
          // starting or stopping the stopwatch.  Also start
          // or stop the timer.
      if (running == false) {
            // Record the time and start the stopwatch.
         running = true;
         startTime = evt.getWhen();  // Time when mouse was clicked.
         setText("Running:  0 seconds");
         if (timer == null) {
            timer = new Timer(100,this);
            timer.start();
         }
         else
            timer.restart();
      }
      else {
            // Stop the stopwatch.  Compute the elapsed time since the
            // stopwatch was started and display it.
         timer.stop();
         running = false;
         long endTime = evt.getWhen();
         double seconds = (endTime - startTime) / 1000.0;
         setText("Time: " + seconds + " sec.");
      }
   }

   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}  // end StopWatchRunner