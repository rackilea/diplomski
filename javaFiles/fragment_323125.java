for(int i = 1; i < 8; i++)
{
    int newrow = row - i;
    int newcolumn = column - i;
    if (newrow < 0 || newrow > 7 || newcolumn < 0 || newcolumn > 7)
    {
       break;
    }
    if (board[newrow][newcolumn])
    {
        return true;
    }
}