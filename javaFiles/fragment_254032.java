import java.awt.*;
import javax.swing.*;

public class LayoutExample {    

    private static final int GAP = 5;
    private static final int TOTAL_LABELS = 18;

    private JTextField tField;
    private JButton button;
    private JLabel[] labels;

    private void displayGUI () {
        JFrame frame = new JFrame ( "Layout Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = getPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP ) );

        JPanel headerPanel = getPanel ();
        headerPanel.setLayout ( new GridLayout ( 0, 1, GAP, GAP ) );
        JPanel textFieldPanel = getPanel ();
        tField = new JTextField ( 10 );
        textFieldPanel.add ( tField );
        JPanel buttonPanel = getPanel ();
        button = new JButton ( "Button" );
        buttonPanel.add ( button );     
        headerPanel.add ( textFieldPanel );
        headerPanel.add ( buttonPanel );
        contentPane.add (headerPanel, BorderLayout.PAGE_START );

        JPanel centerPanel = getPanel ();
        centerPanel.setLayout ( new GridLayout ( 0, 3, GAP, GAP ) );
        labels = new JLabel [ TOTAL_LABELS ];
        for ( int i = 0; i < labels.length; ++i ) {
            labels [ i ] = new JLabel ( String.valueOf ( i ), JLabel.CENTER );
            centerPanel.add ( labels [ i ] );
        }
        contentPane.add ( centerPanel, BorderLayout.CENTER );


        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    private JPanel getPanel () {
        JPanel panel = new JPanel ();
        panel.setOpaque ( true );
        panel.setBorder ( BorderFactory.createEmptyBorder ( GAP, GAP, GAP, GAP ) );

        return panel;
    }

    public static void main ( String[] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new LayoutExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}