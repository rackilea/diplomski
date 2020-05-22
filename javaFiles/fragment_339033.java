static void TestFunction()
    {
        int rows = 5;
        int columns = 6;
        int sourcearr[][] = new int[rows][columns];
        int destinationarr[][] = new int[rows-1][columns-1];

        int REMOVE_ROW = 2;
        int REMOVE_COLUMN = 3;
        int p = 0;
        for( int i = 0; i < rows; ++i)
        {
            if ( i == REMOVE_ROW)
                continue;


            int q = 0;
            for( int j = 0; j < columns; ++j)
            {
                if ( j == REMOVE_COLUMN)
                    continue;

                destinationarr[p][q] = sourcearr[i][j];
                ++q;
            }

            ++p;
        }
    }