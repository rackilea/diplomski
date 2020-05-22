protected void paintComponent ( Graphics g )
{
    Point wl = SwingUtilities.getWindowAncestor ( this ).getLocationOnScreen ();
    Point los = this.getLocationOnScreen ();
    Point zero = new Point ( los.x-wl.x, los.y-wl.y );
    g.translate ( zero.x, zero.y );

    // ...
}