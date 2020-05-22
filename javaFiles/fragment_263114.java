public static void main ( String[] args )
{
    final JFrame frame = new JFrame ();

    final JTabbedPane tabbedPane = new JTabbedPane ();
    tabbedPane.addTab ( "tab1", new JLabel ( "" ) );
    tabbedPane.addTab ( "tab2", new JLabel ( "" ) );
    tabbedPane.addTab ( "tab3", new JLabel ( "" ) );
    tabbedPane.addTab ( "tab4", new JLabel ( "" ) );
    frame.add ( tabbedPane );

    tabbedPane.setUI ( new MetalTabbedPaneUI ()
    {
        protected MouseListener createMouseListener ()
        {
            return new CustomAdapter ( tabbedPane );
        }
    } );

    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
    frame.setVisible ( true );
}

private static class CustomAdapter extends MouseAdapter
{
    private JTabbedPane tabbedPane;

    public CustomAdapter ( JTabbedPane tabbedPane )
    {
        super ();
        this.tabbedPane = tabbedPane;
    }

    public void mousePressed ( MouseEvent e )
    {
        final int index = tabbedPane.getUI ().tabForCoordinate ( tabbedPane, e.getX (), e.getY () );
        if ( index != -1 )
        {
            if ( SwingUtilities.isLeftMouseButton ( e ) )
            {
                if ( tabbedPane.getSelectedIndex () != index )
                {
                    tabbedPane.setSelectedIndex ( index );
                }
                else if ( tabbedPane.isRequestFocusEnabled () )
                {
                    tabbedPane.requestFocusInWindow ();
                }
            }
            else if ( SwingUtilities.isMiddleMouseButton ( e ) )
            {
                tabbedPane.removeTabAt ( index );
            }
            else if ( SwingUtilities.isRightMouseButton ( e ) )
            {
                final JPopupMenu popupMenu = new JPopupMenu ();

                final JMenuItem addNew = new JMenuItem ( "Add new" );
                addNew.addActionListener ( new ActionListener ()
                {
                    public void actionPerformed ( ActionEvent e )
                    {
                        tabbedPane.addTab ( "tab", new JLabel ( "" ) );
                    }
                } );
                popupMenu.add ( addNew );

                final JMenuItem close = new JMenuItem ( "Close" );
                close.addActionListener ( new ActionListener ()
                {
                    public void actionPerformed ( ActionEvent e )
                    {
                        tabbedPane.removeTabAt ( index );
                    }
                } );
                popupMenu.add ( close );

                final JMenuItem closeAll = new JMenuItem ( "Close all" );
                closeAll.addActionListener ( new ActionListener ()
                {
                    public void actionPerformed ( ActionEvent e )
                    {
                        tabbedPane.removeAll ();
                    }
                } );
                popupMenu.add ( closeAll );

                final Rectangle tabBounds = tabbedPane.getBoundsAt ( index );
                popupMenu.show ( tabbedPane, tabBounds.x, tabBounds.y + tabBounds.height );
            }
        }
    }
}