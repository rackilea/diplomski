canvas.addPaintListener(new PaintListener()
{
    public void paintControl(PaintEvent e)
    {
        Point point = canvas.toControl(event.x, event.y);
        e.gc.drawString(d, point.x, point.y);
    }
});