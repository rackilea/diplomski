public static void main ( String[] args )
{
    JFrame frame = new JFrame ();

    JPanel panel = new JPanel ( new BorderLayout () );
    panel.setOpaque ( false );
    WindowMoveAdapter wma = new WindowMoveAdapter ();
    panel.addMouseListener ( wma );
    panel.addMouseMotionListener ( wma );
    frame.getContentPane ().add ( panel );

    panel.add ( new JButton ( "Test" ) );

    final Area shape = createShape ();

    JPanel glassPane = new JPanel ( null )
    {
        public boolean contains ( int x, int y )
        {
            // This is to avoid cursor and mouse-events troubles
            return shape.contains ( x, y );
        }
    };
    glassPane.setOpaque ( false );
    frame.setGlassPane ( glassPane );
    glassPane.setVisible ( true );

    JComponent popup = new JComponent ()
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
    popup.addMouseListener ( new MouseAdapter ()
    {
        // To block events on the popup
    });
    glassPane.add ( popup );
    popup.setBounds ( shape.getBounds () );
    popup.setVisible ( true );

    frame.setSize ( 800, 500 );
    frame.setLocationRelativeTo ( null );

    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setVisible ( true );
}