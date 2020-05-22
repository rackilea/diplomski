public static void main(String[] args)
{
    int[][] a = new int[9][9];
    boolean areThereDuplicates;

    int input = 9; // or any input of course
    int row = 0;   // or any row
    int column = 0;// or any column

    areThereDuplicates = checkDuplicates(input, row, column, a);

    if (!areThereDuplicates) // if there are no duplicates, input value
        a[row][column] = input;
}

public static boolean checkDuplicates(int numChecked, int row, int column, int[][] arr)
{
    // checks row
    for (int j = 0; j < arr[row].length; j++)
    {
        if (arr[row][j] == numChecked)
            return true;
    }

    // checks column
    for (int k = 0; k < arr.length; k++)
    {
        if (arr[k][column] == numChecked)
            return true;
    }

    return false;
}