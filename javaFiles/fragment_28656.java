public void paintComponent(Graphics page)
{
    super.paintComponent(page);

    if (mouseDragged == true)
    {
        int x = Math.min(x1, x3);
        int y = Math.min(y1, y3);
        int width = Math.max(x1, x3) - x;
        int height = Math.max(y1, y3) - y;
        page.drawRect(x, y, width, height);
    }
}