public class Entity
{

    private int xcoordinate;
    private int ycoordinate;
    private String name;
    private char symbol;

    public Entity()
    {
        xcoordinate = 20;
        ycoordinate = 30;
    }

    private Entity(int newxcoor, int newycoor, String newname, char newsymbol)
    {
        xcoordinate = newxcoor;
        ycoordinate = newycoor;
        name = newname;
        symbol = newsymbol;
    }

    public int getXCoor()
    {
        return xcoordinate;
    }

    public void setXCoor(int xcoordinate)
    {
        this.xcoordinate = xcoordinate;
    }

    public int getYCoor()
    {
        return ycoordinate;
    }

    public void setYcoor(int ycoordinate)
    {
        this.ycoordinate = ycoordinate;
    }

    public static void main(String[] args)
    {
        World worldob = new World();

        worldob.draw();

        worldob.move(0, 15, 30);
        worldob.move(1, 45, 0);
        worldob.move(2, 23, 27);
        worldob.move(3, 72, 80);

        worldob.draw();
    }

}

class World
{

    private final Entity[] ObArray;

    public World()
    {
        this.ObArray = new Entity[4];

        for (int i = 0; i < ObArray.length; i++)
        {
            ObArray[i] = new Entity();
        }

    }

    public void move(int index, int xCoor, int yCoor)
    {
        if (index >= 0 && index < ObArray.length)
        {
            Entity e = ObArray[index];
            e.setXCoor(xCoor);
            e.setYcoor(yCoor);
        }
    }

    public void draw()
    {
        for (Entity e : ObArray)
        {
            int x = e.getXCoor();
            int y = e.getYCoor();
            System.out.println("x" + x);
            System.out.println("y" + y);
        }
    }

}