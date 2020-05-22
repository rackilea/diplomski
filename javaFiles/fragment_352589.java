public static boolean columnSumsOK ( int arr[][], int total )
    {
        for ( int j = 0; j < arr [ 0 ].length; j++ )
        {
            int sum = 0;
            for ( int i = 0; i < arr.length; i++ )
                sum = sum + arr [ i ] [ j ];
            if ( sum != total )
                return false;
        }
        return true;
    }