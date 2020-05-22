import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RobotTest
{
    // CHANGE #1: store a queue of virtual key presses.
    public static Queue<Integer> robotKeys = new LinkedList<Integer>();


    public static void main( String[] args )
    {
        new RobotTest();
    }


    public RobotTest()
    {
        // Create a "virtual keyboard"
        MyWindow window = new MyWindow();
        window.setVisible( true );

        // Event listener to differentiate between virtual and physical key events.
        Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener()
        {
            @Override
            public void eventDispatched( final AWTEvent e )
            {
                if (( e instanceof KeyEvent )
                        && ( ( KeyEvent ) e ).getID()==KeyEvent.KEY_PRESSED
                        && ( ( KeyEvent ) e ).getKeyCode()==KeyEvent.VK_A)
                {
                    // CHANGE #2: check the received event against the front of the queue.
                    Integer expectedRobotKey = robotKeys.poll();
                    if (expectedRobotKey != null && expectedRobotKey == ( ( KeyEvent ) e ).getKeyCode())
                    {
                        System.out.println("No physical input detected.");
                    }
                    else
                    {
                        System.out.println("Physical input detected.");
                    }
                }
            }
        }, AWTEvent.KEY_EVENT_MASK);
    }

    // prototype keyboard with an "A" key.
    private class MyWindow extends JFrame
    {
        public MyWindow()
        {
            JPanel content = new JPanel();
            content.setLayout( new BorderLayout() );

            // Button that emulates pressing A
            JButton button = new JButton( "A" );
            button.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    try
                    {
                        Robot r = new Robot();
                        // CHANGE #3: add events to the stored queue before sending them out.
                        robotKeys.add( KeyEvent.VK_A );
                        r.keyPress( KeyEvent.VK_A );
                        r.keyRelease( KeyEvent.VK_A );
                    }
                    catch( AWTException ex )
                    {
                        ex.printStackTrace();
                    }
                }
            });

            content.add( button, BorderLayout.CENTER );
            setContentPane( content );

            setSize(50, 50);
        }
    }
}