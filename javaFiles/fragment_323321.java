int tileWidth = 50;
int tileHeight = 50;
for ( int x = 0; x < 16; x++ )
{
    for ( int y = 0; y < 12; y++ )
    {
        Image tileImage;
        int tileType = fieldArray[x][y];

        switch ( tileType )
        {
            case 0:
            {
                tileImage = myGrassImage;
                break;
            }
            case 2:
            {
                tileImage = myTreeImage;
                break;
            }
        }

        Graphics2D g;
        g.drawImage(tileImage, x * tileWidth, y * tileHeight, null);
    }
}