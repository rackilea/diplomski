public void clearBoard()
{
    for(int x = 0; x < BOARD_SIZE; x++) // changed from x <= BOARD_SIZE
    {
        for(int y = 0; y < BOARD_SIZE; y++) // changed from y <= BOARD_SIZE
        {
            board[x][y] = 0;
        }

    }
}