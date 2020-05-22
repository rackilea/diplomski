/**
 * Return flag indicating if there are duplicates in the rows of the 2D array
 * 
 * @return true if a row has duplicates, else false
 */
public boolean hasDuplicatesInRows(int[][] inArray)
{
    for (int row = 0; row < inArray.length; row++)
    {
        for (int col = 0; col < inArray[row].length; col++)
        {
            int num = inArray[row][col];
            for (int otherCol = col + 1; otherCol < inArray.length; otherCol++)
            {
                if (num == inArray[row][otherCol])
                {
                    return true;
                }
            }
        }
    }

    return false;
}