import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TimerTime extends JFrame implements ActionListener
{
    JLabel timeLabel;

    public TimerTime()
    {
        timeLabel = new JLabel( new Date().toString() );
        getContentPane().add(timeLabel, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e)
    {
        timeLabel.setText( new Date().toString() );
    }

    public static void main(String[] args)
    {
        TimerTime frame = new TimerTime();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);

        int time = 1000;
        javax.swing.Timer timer = new javax.swing.Timer(time, frame);
        timer.setInitialDelay(1);
        timer.start();
    }
}