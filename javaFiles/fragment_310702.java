public static bool BoardFull(char [] [] Board)
{
    for (int row = 0; row < 3; ++row) 
    {
        for (int column = 0; column < 3; ++column) 
        {
            if (Board [row] [column] == '.')
            {
                // a move still exists - board is not full
                return false;
            }
        }  
    }
    return true;
 }