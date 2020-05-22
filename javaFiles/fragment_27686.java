//This code is somehwere in your program
class Turtle
{
     private double x;
     private double y;
     private double direction; //direction in radians
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getDirection() {
        return direction;
    }
    public void setDirection(double direction) {
        while(direction > Math.PI * 2)
        {
            direction -= Math.PI * 2;
        }
        while(direction < 0)
        {
            direction += Math.PI * 2;
        }
        this.direction = direction;
    }
}

private static final int GRID_WIDTH = 400;
private static final int GRID_HEIGHT = 400;


private Turtle myTurtle = new Turtle();
private boolean[][] grid = new boolean[GRID_WIDTH][GRID_HEIGHT];
JFrame myJFrame = new JFrame();
private Graphics gridImage = myJFrame.getGraphics();

private void initialise()
{
    for(int y = 0; y < GRID_HEIGHT; y++)
    {
        for(int x = 0; x < GRID_WIDTH; x++)
        {
            grid[x][y] = false;
        }
    }

    gridImage.setColor(Color.BLACK);
    gridImage.fillRect(0, 0, GRID_WIDTH, GRID_HEIGHT);
    gridImage.setColor(Color.white);
}

//This code would be inside the loop or timer callback function
private void myMainFunction()
{
    double newX, newY;
    double deltaX, deltaY;

    deltaX = Math.cos(myTurtle.getDirection());
    deltaY = Math.sin(myTurtle.getDirection());

    newX = myTurtle.getX() + deltaX;
    newY = myTurtle.getY() + deltaY;

    if(newX < 0)
    {
        newX += GRID_WIDTH; 
    }
    else if(newX > GRID_WIDTH)
    {
        newX -=  GRID_WIDTH;    
    }

    if(newY < 0)
    {
        newY += GRID_HEIGHT; 
    }
    else if(newY > GRID_HEIGHT)
    {
        newY -=  GRID_HEIGHT;   
    }

    grid[(int)Math.floor(newX)][(int)Math.floor(newY)] = true;

    gridImage.fillRect((int)Math.floor(newX), (int)Math.floor(newY), 1, 1);
    myJFrame.update(gridImage);

    myTurtle.setX(newX);
    myTurtle.setY(newY);
}