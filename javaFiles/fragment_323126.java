private boolean bishopAttackOneDirection(int rowdelta, int coldelta, int row, int column)
{
    for(int i = 1; i < 8; i++)
    {
        int newrow = row + rowdelta*i;
        int newcolumn = column + columndelta*i;
        if (newrow < 0 || newrow > 7 || newcolumn < 0 || newcolumn > 7)
        {
           break;
        }
        if (board[newrow][newcolumn])
        {
            return true;
        }
    }
    return false;
}

private boolean BishopAttack(int row, int column)
{
   return BishopAttackInOneDirection(-1, -1, row, column)
   || BishopAttackInOneDirection(1, -1, row, column)
   || BishopAttackInOneDirection(1, 1, row, column)
   || BishopAttackInOneDirection(-1, 1, row, column);
}