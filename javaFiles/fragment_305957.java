public void mouseReleased(MouseEvent event)
{
    int x = event.getXOnScreen();
    int y = event.getYOnScreen();

    if(isPressed)
    {
        RectangleComponent rc = new RectangleComponent(x, y);
        frame.add(rc);
        frame.revalidate();
        frame.repaint();
    }
}