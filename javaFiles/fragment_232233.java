@Override
public void paintComponent(Graphics g)//paints circle on the screen
{
    super.paintComponent(g); //prepares graphic object for drawing

    int originX = getWidth() / 2;
    int originY = getHeight() / 2;

    int x = originX - (d / 2);
    int y = originY - (d / 2);
    System.out.println(x + "x" + y);

    g.fillRect(x, y, d, d); //paints rectangle on screen
    //x , y, width, height

}