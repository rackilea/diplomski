@Override
public void paint(Graphics g)
{
    BufferedImage buffer = new BufferedImage(COMPONENT_WIDTH, COMPONENT_HEIGHT, BufferedImage.TYPE_INT_ARGB);

    Graphics bufferG = buffer.getGraphics();

    super.paint(bufferG);
    if (showUserSelection)
    {
        Point startDrawPoint = new Point(Math.min(startSelectPoint.x,
                endSelectPoint.x), Math.min(startSelectPoint.y,
                endSelectPoint.y));
        Point endDrawPoint = new Point(Math.max(startSelectPoint.x,
                endSelectPoint.x), Math.max(startSelectPoint.y,
                endSelectPoint.y));
        int w = endDrawPoint.x - startDrawPoint.x;
        int h = endDrawPoint.y - startDrawPoint.y;
        if (w > 0 && h > 0)
        {
            bufferG.fillRect(startDrawPoint.x, startDrawPoint.y, w, h);

        }
    }

    g.drawImage(buffer, 0, 0, null);
}