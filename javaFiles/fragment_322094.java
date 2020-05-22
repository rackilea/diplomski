class MyMouseListener extends MouseInputAdapter
{
    private Point startPoint;

    public void mousePressed(MouseEvent e)
    {
        startPoint = e.getPoint();
        shape = new Rectangle();
    }

    public void mouseDragged(MouseEvent e)
    {
        int x = Math.min(startPoint.x, e.getX());
        int y = Math.min(startPoint.y, e.getY());
        int width = Math.abs(startPoint.x - e.getX());
        int height = Math.abs(startPoint.y - e.getY());

        shape.setBounds(x, y, width, height);
        repaint();
    }

    public void mouseReleased(MouseEvent e)
    {
        if (shape.width != 0 || shape.height != 0)
        {
            addRectangle(shape, e.getComponent().getForeground());
        }

        shape = null;
    }
}