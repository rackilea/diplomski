public void rowN(int n, int y)
{
    if(onBoard(n, y) != -1)     
    {
        if(validMove(n, y) == 0) //if the move is valid (0) then it puts a 1 at those coordinates and moves on to the next method (RowTwo)
        {
            board[n][y] = 1;
            if(n<7) {
                rowN(n+1, 0);
            }
            else {
                count++;
                System.out.println(toString());
            }
        }

        board[n][y] = 0;
        rowN(n, y + 1);
    }
}