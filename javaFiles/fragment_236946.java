public boolean phys(Player plr)
{
    java.awt.Rectangle playerBounds = new java.awt.Rectangle(plr.x, plr.y, BLOCK_SIZE, BLOCK_SIZE);

    for (int y = 0; y < 3; y++)
    {
        for (int x = 0; x < 3; x++)
        {
            // Skip the tile the player is on assuming that he is not on a wall already
            if (x == 1 && y == 1) continue;

            java.awt.Rectangle bounds = new java.awt.Rectangle(/*tile at (x, y) xpos*/, /*tile at (x, y) ypos*/, BLOCK_SIZE, BLOCK_SIZE);

            if (bounds.intersects(playerBounds))
            {
                return true;
            }
        }
    }

    // Did not collide
    return false;
}