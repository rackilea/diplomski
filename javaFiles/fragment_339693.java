package timertest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerTest implements ActionListener {

    JLabel timeDisplay;
    long startTime;
    Timer timer;
    int seconds;

    public void createAndShowGUI()  {
        JFrame frame=new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timeDisplay=new JLabel("0");
        frame.getContentPane().add(timeDisplay);
        frame.pack();
        frame.setVisible(true);

        startTime=System.currentTimeMillis();
        seconds=1;
        timer=new Timer(1000, this);
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerTest().createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long now=System.currentTimeMillis();
        long elapsed=now-startTime;
        seconds++;
        timeDisplay.setText(elapsed+" Milliseconds since start");
        timer.setInitialDelay((int)(startTime+seconds*1000-now));
        timer.start();
    }
}