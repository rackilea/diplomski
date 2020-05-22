class MouseDraggingControl implements MouseMotionListener 
{
    private Point previousPoint = new Point();

    @Override 
    public void mouseMoved(MouseEvent e)
    {
        previousPoint = e.getPoint();
    }

    @Override 
    public void mouseDragged(MouseEvent e)
    {
        int movementX = e.getX() - previousPoint.x;
        int movementY = e.getY() - previousPoint.y;

        doMovement(movementX, movementY);

        previousPoint = e.getPoint();
    }
}