public Tiles getTile(int x, int y)
{
    int row = y / 20;
    int column = x / 20;

    return Tiles.values()[mapArray[row][column]];
}