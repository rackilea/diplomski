public int maxDegree()
{
    int max = degree(g[0]);

    for( int node = 1; node < g.length; node++ )
    {
        if( degree(g[node]) > max ) 
        {
            max = degree(g[node]);
        }
    }

    return max;
}

public int minDegree()
{
    int min = degree(g[0]);

    for( int node = 1; node < g.length; node++ )
    {
        if( degree(g[node]) < min ) 
        {
            min = degree(g[node]);
        }
    }

    return min;
}