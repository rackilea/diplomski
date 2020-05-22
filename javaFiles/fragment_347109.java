private static void InitializeBoard()
{
    char a = ' ';
    for (int i = 0; i < board.length; i++)
    {
        for (int e = 0; e < board[i].length; e++)
            board[i][e] = a;
    }
}