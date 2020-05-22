import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelColourExample {

    private Timer timer;
    private JLabel label;
    private Color [] colours = { 
        Color.red,
        Color.blue,
        Color.green,
        Color.cyan,
        Color.yellow,
        Color.magenta,
        Color.black,
        Color.white
    };
    private int counter;

    private static final int GAP = 5;   

    private ActionListener timerActions = new ActionListener () {
        @Override
        public void actionPerformed ( ActionEvent ae ) {
            label.setForeground ( colours [ counter++ ] );
            counter %= colours.length;
        }
    };

    public LabelColourExample () {
        counter = 0;
    }

    private void displayGUI () {        
        JFrame frame = new JFrame ( "Label Colour Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP ) );

        label = new JLabel ( "MyName", JLabel.CENTER );
        label.setOpaque ( true );
        contentPane.add ( label, BorderLayout.CENTER );

        JButton button = new JButton ( "Stop" );
        button.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent ae ) {
                JButton button = ( JButton ) ae.getSource ();
                if ( timer.isRunning () ) {
                    timer.stop ();
                    button.setText ( "Start" );
                } else {
                    timer.start ();
                    button.setText ( "Stop" );
                }
            }
        } );
        contentPane.add ( button, BorderLayout.PAGE_END );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );

        timer = new Timer ( 1000, timerActions );
        timer.start ();
    }

    public static void main ( String[] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new LabelColourExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}