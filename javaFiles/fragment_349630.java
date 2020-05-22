import junit.framework.Assert;

class Ghost
{
    private int x, y, direction;

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    public static void main (String [] args)
    {
        Ghost g = new Ghost();
        g.setX(10);
        g.setY(20);

        Assert.assertEquals(g.getDirection(), 0);

        System.out.println(g.getX() + " " + g.getY() + " " + g.getDirection());
    }   
}