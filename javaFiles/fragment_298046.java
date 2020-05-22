static void Peak(int[,] map, int left, int right)
    {
        // calculate middle column
        int column = (right + left) / 2;


        // get max row in column
        int arow = 0;
        for (int row = 0; row < map.GetLength(0); row++)
            if (map[row, column] > map[arow, column])
                arow = row;

        int a = map[arow, column];

        // get left value
        int b = 0;
        if (column - 1 >= left) b = map[arow, column - 1];
        // get right value
        int c = 0;
        if (column + 1 <= right) c = map[arow, column + 1];

        // if left is higher, recurse left
        if (b > a) Peak(map, left, column - 1);
        // else if right is higher, recurse right
        else if (c > a) Peak(map, column + 1, right);
        // else, peak
        else Console.WriteLine("Peak: " + arow + " " + column + " " + a);
    }

    static void Main(string[] args)
    {
        int[,] map = { {12, 8, 5},
                       {11, 3, 6 },
                       {10, 9, 2 },
                       { 8, 4, 1 } };
        Peak(map, 0, 2);
        Console.ReadLine();
    }