public Player getPlayer(int x, int y)
{
    // Note: Java doesn't have "real" multidimensional arrays,
    // only arrays of arrays.
    return squares[x][y];
}

public Player setPlayer(int x, int y, Player player)
{
    squares[x][y] = player;
}