public class Example
{
    public static void main ( String[] args )
    {
        JPanel panel = new JPanel ( new FlowLayout () )
        {
            protected void paintComponent ( Graphics g )
            {
                super.paintComponent ( g );
                g.setColor ( Color.BLACK );
                g.drawLine ( 0, 0, getWidth (), getHeight () );
            }
        };
        panel.add ( new JLabel ( "label" ) );
        panel.add ( new JButton ( "button" ) );
        panel.add ( new JCheckBox ( "check" ) );


        JFrame frame = new JFrame (  );
        frame.add ( panel );
        frame.pack ();
        frame.setVisible ( true );

        BufferedImage bi = new BufferedImage ( panel.getWidth (), panel.getHeight (), BufferedImage.TYPE_INT_ARGB );
        Graphics2D g2d = bi.createGraphics ();
        panel.paintAll ( g2d );
        g2d.dispose ();

        try
        {
            ImageIO.write ( bi, "png", new File ( "C:\\image.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace ();
        }

        System.exit ( 0 );
    }
}