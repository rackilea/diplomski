import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mikle Garin
 * @see http://stackoverflow.com/a/18590057/909085
 */

public class ButtonSleep
{
    public static void main ( String[] args )
    {
        JFrame frame = new JFrame ( "Custom list renderer" );

        final JButton button = new JButton ( "Make me sleep 5 seconds" );
        button.addActionListener ( new ActionListener ()
        {
            @Override
            public void actionPerformed ( ActionEvent e )
            {
                button.setEnabled ( false );
                new Thread ( new Runnable ()
                {
                    @Override
                    public void run ()
                    {
                        try
                        {
                            Thread.sleep ( 5000 );
                        }
                        catch ( InterruptedException e1 )
                        {
                            //
                        }
                        SwingUtilities.invokeLater ( new Runnable ()
                        {
                            @Override
                            public void run ()
                            {
                                button.setEnabled ( true );
                            }
                        } );
                    }
                } ).start ();
            }
        } );
        frame.add ( button );

        frame.pack ();
        frame.setLocationRelativeTo ( null );
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.setVisible ( true );
    }
}