public boolean collide(pizza f, player p)
{
    if(Math.pow(f.x1-p.x, 2) + Math.pow(f.y1-p.y, 2) <= Math.pow(f.Width/2 + p.Width/2, 2))
    {
        System.out.println("they collided");
        return true;
    }
    else
    {
        return false;
    }
}