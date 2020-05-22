stringToInteger(String correctBase, int [][] board)
{
    int integerNum;
    int row = board.length - 1;
    int col = board[0].length - 1;

    for(int i=correctBase.length()-1; i>=0; i--)         
    {
        integerNum=correctBase.charAt(i)-'0';
        board[row][col]=integerNum;
        col--;
        if(col < 0) {
            col = board[0].length - 1;
            row--;
        }
    }
    ...
}