/**
 * Draw a line on the page using the current non stroking color and the current line width.
 *
 * @param xStart The start x coordinate.
 * @param yStart The start y coordinate.
 * @param xEnd The end x coordinate.
 * @param yEnd The end y coordinate.
 * @throws IOException If there is an error while drawing on the screen.
 */
public void drawLine(float xStart, float yStart, float xEnd, float yEnd) throws IOException
{
    if (inTextMode)
    {
        throw new IOException("Error: drawLine is not allowed within a text block.");
    }
    addLine(xStart, yStart, xEnd, yEnd);
    // stroke
    stroke();
}