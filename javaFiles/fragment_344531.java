public static void main ( String[] args )
{
    JFrame frame = new JFrame ();
    frame.setUndecorated ( true );

    final Area shape = createShape ();
    JPanel panel = new JPanel ()
    {
        protected void paintComponent ( Graphics g )
        {
            super.paintComponent ( g );

            Graphics2D g2d = ( Graphics2D ) g;
            g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON );

            g2d.setPaint ( Color.BLACK );
            g2d.fill ( shape );
        }
    };
    panel.setOpaque ( false );
    WindowMoveAdapter wma = new WindowMoveAdapter ();
    panel.addMouseListener ( wma );
    panel.addMouseMotionListener ( wma );
    frame.getContentPane ().add ( panel );

    AWTUtilities.setWindowOpaque ( frame, false );
    frame.setSize ( shape.getBounds ().getSize () );
    frame.setLocationRelativeTo ( null );

    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setVisible ( true );
}