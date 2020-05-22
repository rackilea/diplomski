public class Box extends JPanel
{
    public Box ()
    {
        super ();

        DashedBorder dashedBorder = new DashedBorder ();
        this.setBorder ( new TitledBorder ( dashedBorder, "title", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION ) );
        this.setLayout ( new GridLayout ( 5, 1 ) );
        for ( int i = 1; i <= 15; i++ )
        {
            this.add ( new JCheckBox ( "" + i ) );
        }
    }

    class DashedBorder extends AbstractBorder
    {
        @Override
        public void paintBorder ( Component comp, Graphics g, int x, int y, int w, int h )
        {
            Graphics2D g2d = ( Graphics2D ) g;
            g2d.setColor ( Color.black );
            final Stroke os = g2d.getStroke ();
            g2d.setStroke ( new BasicStroke ( 1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{ 5 }, 0 ) );
            g2d.drawRect ( x, y, w - 1, h - 1 );
            g2d.setStroke ( os );
        }
    }

    public static void main ( String[] args )
    {
        JFrame frame = new JFrame ();
        JPanel p = new JPanel ();
        p.setLayout ( new BorderLayout () );
        Box box = new Box ();
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.setSize ( 400, 400 );
        frame.setContentPane ( p );
        p.add ( box, BorderLayout.CENTER );
        frame.setLocationRelativeTo ( null );
        frame.setVisible ( true );
    }
}