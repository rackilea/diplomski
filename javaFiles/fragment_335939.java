static boolean collisionDown(Entity e)
{
    Rectangle player = new Rectangle(e.getX(), e.getY() + e.getVelocity(), e.getWidth(), e.getHeight());
    for(Block i : Game.blocks)
    {
        Rectangle block = new Rectangle(i.getX(), i.getY(), size, size );
        if (player.intersects(block))
        {
            //e.goUp(1);
            return true;
        }
    }
    return false;
}