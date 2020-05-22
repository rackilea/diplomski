public void mouseReleased(MouseEvent event)
{
    pt = event.getPoint();
    if (pt != null)
    {
        xEnd = pt.x;
        yEnd = pt.y;


        // !!!! don't do this !!!!
        page.fillRect(xStart, yStart, xEnd-xStart, yEnd-yStart);
    }
}