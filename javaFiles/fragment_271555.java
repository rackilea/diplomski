private static void processArray(int[] inArray)
{
    int[][] array = new int[20][20];

    for (int x = 0; x < 20; x++)
    {
        for (int y = 0; y < 20; y++)
        {
            array[x][y] = inArray[x * 20 + y];  // or devise your own calculation
        }
    }
}