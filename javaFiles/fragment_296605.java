public void getMaximumOfEveryColumn ()
{
    for ( int i = 0; i < A.length; i++ )
    {
        max = Integer.MIN_VALUE;
        for ( int j = 0; j < A [ i ].length; j++ )
            if ( A [ j ] [ i ] > max )
                max = A [ j ] [ i ];
        System.out.println( "Maximum of column " + i + " = " + max );
    }
}

public void getMinimumOfEveryColumn ()
{
    for ( int i = 0; i < A.length; i++ )
    {
        min = Integer.MAX_VALUE;
        for ( int j = 0; j < A [ i ].length; j++ )
            if ( A [ j ] [ i ] < min )
                min = A [ j ] [ i ];
        System.out.println( "Minimum of column " + i + " = " + min );
    }
}
public void getMaximumOfEveryRow ()
{
    for ( int i = 0; i < A.length; i++ )
    {
        max = Integer.MIN_VALUE;
        for ( int j = 0; j < A [ i ].length; j++ )
            if ( A [ i ] [ j ] > max )
                max = A [ i ] [ j ];
        System.out.println( "Maximum of row " + i + " = " + max );
    }
}

public void getMinimumOfEveryRow ()
{
    for ( int i = 0; i < A.length; i++ )
    {
        min = Integer.MAX_VALUE;
        for ( int j = 0; j < A [ i ].length; j++ )
            if ( A [ i ] [ j ] < min )
                min = A [ i ] [ j ];
        System.out.println( "Minimum of row " + i + " = " + min );
    }
}