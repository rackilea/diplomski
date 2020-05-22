@Override
    public void mousePressed( Container source, MouseEvent e ) {

        String newItem = null;
        Point clickPoint = SwingUtilities.convertPoint( source, e.getX(), e.getY(), this );
        // some code here
        if( bounds.contains( clickPoint ) ) {
        // some more code here