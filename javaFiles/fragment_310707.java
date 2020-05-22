for ( int x = 0; x < index[0].length; x++ )
{
    if ( index[0][x] == null )
        continue; // skip possible null entries.

    if ( index[0][x].contains(var) )
    {
        System.out.println("x = " + x + ", val = " + index[0][x]);
        return x; // return the position found.
    }
}