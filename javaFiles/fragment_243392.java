public double powSqrt(double x, double y)
    {
        int den = 1024, num = (int)(y*den), iterations = 10;
        double n = Double.MAX_VALUE;

        while( n >= Double.MAX_VALUE && iterations > 1)
        {
            n = x;

            for( int i=1; i < num; i++ )n*=x;

            if( n >= Double.MAX_VALUE ) 
            {
                iterations--;
                den = (int)(den / 2);
                num = (int)(y*den);
            }
        }   

        for( int i = 0; i <iterations; i++ )n = Math.sqrt(n);

        return n;
    }