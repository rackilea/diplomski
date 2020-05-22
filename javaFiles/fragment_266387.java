public static void main ( String[] args )
{
    try
    {
        UIManager.setLookAndFeel ( UIManager.getSystemLookAndFeelClassName () );
    }
    catch ( Throwable e )
    {
        e.printStackTrace ();
    }

    JFrame frame = new JFrame ();
    frame.setUndecorated ( true );

    frame.setLayout ( new LayoutManager ()
    {
        private List<Component> special = new ArrayList<Component> ();

        public void addLayoutComponent ( String name, Component comp )
        {
            if ( name != null )
            {
                special.add ( comp );
            }
        }

        public void removeLayoutComponent ( Component comp )
        {
            special.remove ( comp );
        }

        public Dimension preferredLayoutSize ( Container parent )
        {
            Dimension ps = new Dimension ();
            for ( Component component : parent.getComponents () )
            {
                if ( !special.contains ( component ) )
                {
                    Dimension cps = component.getPreferredSize ();
                    ps.width = Math.max ( ps.width, cps.width );
                    ps.height = Math.max ( ps.height, cps.height );
                }
            }
            return ps;
        }

        public Dimension minimumLayoutSize ( Container parent )
        {
            return preferredLayoutSize ( parent );
        }

        public void layoutContainer ( Container parent )
        {
            Insets insets = parent.getInsets ();
            for ( Component component : parent.getComponents () )
            {
                if ( !special.contains ( component ) )
                {
                    component.setBounds ( insets.left, insets.top,
                            parent.getWidth () - insets.left - insets.right,
                            parent.getHeight () - insets.top - insets.bottom );
                }
                else
                {
                    Dimension ps = component.getPreferredSize ();
                    component.setBounds ( parent.getWidth () - insets.right - 2 - ps.width,
                            insets.top + 2, ps.width, ps.height );
                }
            }
        }
    } );

    final JTabbedPane tabbedPane = new JTabbedPane ();
    tabbedPane.addTab ( "Tab1", new JLabel () );
    tabbedPane.addTab ( "Tab2", new JLabel () );
    tabbedPane.addTab ( "Tab3", new JLabel () );
    frame.add ( tabbedPane );

    final JLabel label = new JLabel ( "Close X" );
    label.addMouseListener ( new MouseAdapter ()
    {
        public void mousePressed ( MouseEvent e )
        {
            System.exit ( 0 );
        }
    } );
    frame.add ( label, "special", 0 );

    frame.setSize ( 200, 150 );
    frame.setLocationRelativeTo ( null );
    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setVisible ( true );
}