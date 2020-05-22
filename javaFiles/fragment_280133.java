int[][] sum = new int[a.length][];
    for (int row = 0; row < a.length; row++)
    {
        sum[row] = new int[a[row].length];
        for (int column = 0; column < a[row].length; column++)  
            sum[row][column] = a[row][column] + b[row][column];
    }