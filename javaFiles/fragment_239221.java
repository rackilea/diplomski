PropertyChangeListener propertyChangeListener = new PropertyChangeListener ()
{
    @Override
    public void propertyChange ( final PropertyChangeEvent evt )
    {
        if ( evt.getNewValue () == Boolean.TRUE )
        {
            // Retrieving popup menu window (we won't find it if it is inside of parent frame)
            final Window ancestor = getWindowAncestor ( popupMenu );
            if ( ancestor != null && ancestor.getClass ().getCanonicalName ().endsWith ( "HeavyWeightWindow" ) )
            {
                // Checking that parent window for our window is opaque, only then setting opacity
                final Component parent = ancestor.getParent ();
                if ( parent != null && parent instanceof Window && parent.getBackground ().getAlpha () == 0 )
                {
                    // Making popup menu window non-opaque
                    ancestor.setBackground ( new Color ( 0, 0, 0, 0 ) );
                }
            }
        }
    }

    private Window getWindowAncestor ( Component component )
    {
        if ( component == null )
        {
            return null;
        }
        if ( component instanceof Window )
        {
            return ( Window ) component;
        }
        for ( Container p = component.getParent (); p != null; p = p.getParent () )
        {
            if ( p instanceof Window )
            {
                return ( Window ) p;
            }
        }
        return null;
    }
};
popupMenu.addPropertyChangeListener ( "visible", propertyChangeListener );