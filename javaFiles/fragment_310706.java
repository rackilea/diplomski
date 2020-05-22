while ( x < index[0].length )
{
    if ( index[0][x] == null )
    {
        x++;
        continue; // skip possible null entries.
    }

    if ( index[0][x].contains(var) )
    {
        System.out.println("x = " + x + ", val = " + index[0][x]);
        return x; // return the position found.
    }
    x++;
}
return -1;