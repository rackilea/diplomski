JavaRDD parsedData = data.map( o -> o.toString() )
    .map( s -> 
    {
        String[] sarray = s.split( " " );
        double[] values = new double [sarray.length];
        for( int i = 0; i < sarray.length; i++ ) 
        {
            values[i] = Double.parseDouble( sarray[i] );
        }
        return Vectors.dense( values );
    });
    parsedData.cache();