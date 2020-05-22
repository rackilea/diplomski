static boolean _isSafe(boolean board[][], int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (board[i][col])
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j])
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<board.length; i++, j--)
            if (board[i][j])
                return false;

        return true;
    }