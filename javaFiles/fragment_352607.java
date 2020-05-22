boolean isValidMove(int num, int row, int col)
{
    //1. Check whether the horizontal run contains the number
    for (int i = 0; i < 9; i++)
        if (board[row][i] == num) return false;

    //2. Check whether the vertical run contains the number
    for (int i = 0; i < 9; i++)
        if (board[i][col] == num) return false;

    //3. Check whether the 3x3 grid contains the number
    int starting_row = row / 3;
    int starting_col = col / 3;

    for (int i = starting_row * 3; i < starting_row * 3 + 3; i++)
        for (int j = starting_col * 3; j < starting_col * 3 + 3; j++)
            if (board[i][j] == num) return false;

    return true;
}