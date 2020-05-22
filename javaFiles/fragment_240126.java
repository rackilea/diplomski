public static int indexSmall(int[] array)
{
    int row = 0;
    int col = 0;
    int low = array[row][col];
    for(int i = 0; i < array.length; i++) //array.length is the number of 
                                          //arrays in the 2D array aka the number of rows
    {
        for(int j = 0; j < array[i].length; j++) //array[i].length is the number of elements
                                                 //in one of the arrays in the 2D arrays aka 
                                                 //the number of columns
            {
            if (low > array[i][j])
            {
                low = array[i][j];
                row = i;
                col = j
            }
        }
    }

    return row; //you can also return col or a combination of the two
}