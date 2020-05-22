public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    drawSierpTriangle(g, this.x, this.y, this.side);
    g.drawRect(x,y,1,1);
}

public void drawSierpTriangle(Graphics g, int x, int y, int size) 
{
    if (size == 1)
    {
        //Draw rectangle? This is where I need help

        g.drawRect(x,y,1,1); //this does not work, passing Graphics g into the method also does not work
    } 
    else 
    {
        drawSierpTriangle(g, x/2, y, size/2);
        drawSierpTriangle(g, x,y/2,size/2);
        drawSierpTriangle(g, x/2,y/2,size/2);
    }   
}