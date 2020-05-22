/**
 * @author Mikle Garin
 */
public class OpacityGlitch
{
    public static void main ( String[] args )
    {
        SwingUtilities.invokeLater ( () -> {
            final JFrame frame = new JFrame ( "Opacity glitch sample" );

            // Opaque by default
            final JPanel panel = new JPanel ( null );

            // Opaque by default, but might vary with L&F
            final JButton button1 = new JButton ( "1111111" );
            panel.add ( button1 );

            // Non-opaque to demonstrate the problem
            final JButton button2 = new JButton ( "2222222" );
            panel.add ( button2 );

            // Intersecting buttons
            button1.setBounds ( 100, 100, 150, 30 );
            button2.setBounds ( 130, 115, 150, 30 );

            frame.getContentPane ().add ( panel );

            frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
            frame.setSize ( 500, 500 );
            frame.setLocationRelativeTo ( null );
            frame.setVisible ( true );
        } );
    }
}