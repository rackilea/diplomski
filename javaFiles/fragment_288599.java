public int maxDegree()
{
    int max = 0;

    for( int node = 0; node < g.length; node++ )
    {
        if( degree(node) > max ) 
        {
            return degree(node);
        }
    }

    // MISSING A RETURN OF A DEFAULT VALUE HERE
}

public int minDegree()
{
    int min = g.length-1;

    for( int node = 0; node < g.length; node++ )
    {
        if( degree(node) < min ) 
        {
            return degree(node);
        }
    }

    // MISSING A RETURN OF A DEFAULT VALUE HERE
}