public void setBoard(int row, int col, Piece a)
{
    for (int x = 0; x < board.length; x++)
    {
        for (int y = 0; y < board[0].length; y++)
        {
            board[x][y] = a;
        }
    }
}