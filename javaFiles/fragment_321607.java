public class ImageDrawTest
{
    public static void main ( String[] args )
    {    
        final ImageIcon icon = new ImageIcon ( "C:\\large.jpg" );

        JComponent c = new JComponent ()
        {
            protected void paintComponent ( Graphics g )
            {
                super.paintComponent ( g );

                long time = System.nanoTime ();
                g.drawImage ( icon.getImage (), 0, 0, null );
                time = System.nanoTime () - time;
                System.out.println ( time );
            }
        };

        JFrame f = new JFrame ();
        f.getContentPane ().setLayout ( new BorderLayout () );
        f.getContentPane ().add ( c );
        f.setSize ( 200, 100 );
        f.setLocationRelativeTo ( null );
        f.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        f.setVisible ( true );
    }
}