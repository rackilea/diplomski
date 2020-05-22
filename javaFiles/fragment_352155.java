private void drawUnderlinedText(GC gc, String string, int x, int y)
{
    Point extent = gc.textExtent(string);
    gc.drawText(string, x, y);
    gc.drawLine(x - 1, y + extent.y - 1, x + extent.x - 1, y + extent.y - 1);
}