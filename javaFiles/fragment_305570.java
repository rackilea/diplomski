class Ship
{
    //make your polygon points members of the class
    //so that you can have state that changes
    //instead of declaring them in the paint method
    int shipX[] = {500,485,500,515,500};
    int shipY[] = {500,485,455,485,500};
    //set these to the amount you want per update. They can even be negative 
    int velocityX = 1;
    int velocityY = 1;

    public void paint(Graphics g)
    {
        g.setColor(Color.cyan);
        g.fillPolygon(shipX, shipY, 5);
    }

    public void move()
    {
        //add 1 to each value in shipX
        for (int i=0; i<shipX.length; i++)
        {
            shipX[i] += velocityX;
        }
        //add 1 to each value in shipY
        for (int i=0; i<shipY.length;i++)
        {
            shipY[i] += velocityY;
        }
        //call whatever you use to force a repaint
        //normally I would assume your class extended
        //javax.swing.JComponent, but you don't show it in your code
        //if so, just uncomment:
        //this.repaint();
    }
}