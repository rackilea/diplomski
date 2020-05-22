class MouseDraggingControl implements MouseMotionListener 
{
    private Point previousPoint = new Point();

    @Override 
    public void mouseMoved(MouseEvent e)
    {
        previousPoint = e.getLocationOnScreen();
    }

    @Override 
    public void mouseDragged(MouseEvent e)
    {
        Point p = e.getLocationOnScreen();
        int movementX = p.x - previousPoint.x;
        int movementY = p.y - previousPoint.y;

        doMovement(movementX, movementY);

        previousPoint = e.getLocationOnScreen();
    }
}