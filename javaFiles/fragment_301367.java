private void countAdjacentMines()
{        
    for (int i = 0; i < mineField.length; i++)
    {
        for (int j = 0; j < mineField.length; j++)
        {
            if (!(mineField[i][j].getIsMine()))
            {
                int count = 0;

                for (int p = i - 1; p <= i + 1; p++)
                {
                    for (int q = j - 1; q <= j + 1; q++)
                    {
                        if (0 <= p && p < mineField.length && 0 <= q && q < mineField.length)
                        {
                            if (mineField[p][q].getIsMine())
                                ++count;
                        }
                    }
                }

                mineField[i][j].setAdjacentMines(count);
            }
        } // end for loop rows
    } // end for loop columns
} // end countAdjacentMines