public void drawSquare(Graphics g, int x, int y, int size)
{
    g.drawRect(x,y,size,size);
    if(size >2 && x < 1001 && y <= 200)
    {
        x+= 10+size;     
        int newSize = size*3/4;
        y = y + size - newSize; // (size - newSize) is the difference
        size = newSize;
        drawSquare(g,x,y,size);
    }
}