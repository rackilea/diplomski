static int  laskeSuurinAlue(int[][] array) {
    int counter = 0;

    int rowLimit = array.length;
    int colLimit = array[0].length;

    for (int r = 0; r < rowLimit; r++)
    {
        for (int c = 0; c < colLimit; c++)
        {
            if (array[r][c] == 0) {
                continue;
            }

            int sum = array[r][c];
            sum += (r + 1 < rowLimit) ? array[r+1][c] : 0;
            sum += (c + 1 < colLimit) ? array[r][c+1] : 0;
            sum += (r - 1 >= 0 ) ? array[r-1][c] : 0;
            sum += (c - 1 >= 0) ? array[r][c-1] : 0;

            if (sum > 1) {
                counter++;
            }
        }
    }
    return counter;
}