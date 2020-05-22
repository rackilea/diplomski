public static void matricize (int [] list, int [][] matrix)
{
    int listIndex = 0;
    //loop through each row
    for (row=0; row<matrix.length; row++)
    {
        //loop through each column
        for (col=0; col<matrix[row].length; col++)
        {
            //populate matrix with values from list
            matrix[row][col] = list[listIndex++];
        }
    }
}