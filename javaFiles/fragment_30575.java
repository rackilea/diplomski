/*
   A trivial applet that tests the StopWatchRunner component.
   The applet just creates and shows a StopWatchRunner.
*/


import java.awt.*;
import javax.swing.*;

public class Test1 extends JApplet {

   public void init() {

      StopWatch watch = new StopWatch();
      watch.setFont( new Font("SansSerif", Font.BOLD, 24) );
      watch.setBackground(Color.white);
      watch.setForeground( new Color(180,0,0) );
      watch.setOpaque(true);
      getContentPane().add(watch, BorderLayout.CENTER);

   }

}