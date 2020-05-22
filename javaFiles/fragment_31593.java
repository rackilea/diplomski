super.paint(g);
Graphics2D g2d = (Graphics 2D)g;

// find the block with the player (might need correction)
int playerX = (int) (player.getX() / 32);
int playerY = (int) (player.getY() / 32);

int viewDist = 6;

int lowerX = Math.max(playerX - viewDist, 0);
int upperX = Math.min(playerX + viewDist + 1, 50);
int lowerY = Math.max(playerY - viewDist, 0);
int upperY = Math.min(playerY + viewDist +  1, 50);

for (int x = lowerX; x < upperX; x++)
{
    for (int y = lowerY; y < upperY; y++)
    {
        Block next = new Block(blocks[x][y], x, y);
        g2d.drawImage(next.getImage(), (next.getX() - player.getX()),    
                      (next.getY() - player.getY()), this);
    }
}