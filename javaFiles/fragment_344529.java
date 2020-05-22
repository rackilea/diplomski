public static class WindowMoveAdapter extends MouseAdapter
{
    private boolean dragging = false;
    private int prevX = -1;
    private int prevY = -1;

    public WindowMoveAdapter ()
    {
        super ();
    }

    public void mousePressed ( MouseEvent e )
    {
        if ( SwingUtilities.isLeftMouseButton ( e ) )
        {
            dragging = true;
        }
        prevX = e.getXOnScreen ();
        prevY = e.getYOnScreen ();
    }

    public void mouseDragged ( MouseEvent e )
    {
        if ( prevX != -1 && prevY != -1 && dragging )
        {
            Window w = SwingUtilities.getWindowAncestor ( e.getComponent () );
            if ( w != null && w.isShowing () )
            {
                Rectangle rect = w.getBounds ();
                w.setBounds ( rect.x + ( e.getXOnScreen () - prevX ),
                        rect.y + ( e.getYOnScreen () - prevY ), rect.width, rect.height );
            }
        }
        prevX = e.getXOnScreen ();
        prevY = e.getYOnScreen ();
    }

    public void mouseReleased ( MouseEvent e )
    {
        dragging = false;
    }
}