public static void main ( String[] args )
{
    JFrame frame = new JFrame ();
    frame.setUndecorated ( true );

    JPanel panel = new JPanel ();
    panel.setBackground ( Color.BLACK );
    WindowMoveAdapter wma = new WindowMoveAdapter ();
    panel.addMouseListener ( wma );
    panel.addMouseMotionListener ( wma );
    frame.getContentPane ().add ( panel );

    Area shape = createShape ();
    AWTUtilities.setWindowShape ( frame, shape );
    frame.setSize ( shape.getBounds ().getSize () );
    frame.setLocationRelativeTo ( null );

    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setVisible ( true );
}