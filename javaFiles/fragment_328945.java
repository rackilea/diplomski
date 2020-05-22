import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TimerTest extends JPanel implements ActionListener
{
    JLabel timeLabel;
    JLabel scrollLabel;

    public TimerTest()
    {
        setLayout( new BorderLayout() );

        timeLabel = new JLabel( new Date().toString() );
        add(timeLabel, BorderLayout.NORTH);

        scrollLabel = new JLabel( "Some continuously scrolling text!!      " );
        add(scrollLabel, BorderLayout.SOUTH);

        int time = 1000;
        javax.swing.Timer timer = new javax.swing.Timer(time, this);
        timer.setInitialDelay(1);
        timer.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        timeLabel.setText( new Date().toString() );
        String oldText = scrollLabel.getText();

        // Scroll right to left
        String newText = oldText.substring(1) + oldText.substring(0, 1);

        // Scroll left to right
//      int length = oldText.length();
//      String newText = oldText.substring(length-1, length)
//          + oldText.substring(0, length-1);

        scrollLabel.setText( newText );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new TimerTest() );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}