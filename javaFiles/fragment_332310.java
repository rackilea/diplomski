int []a = {-1, 3, -1, 9, 4, -4};

    int from=0, to=0;

    int maxSum = 0, thisSum = 0, thisFrom = 0 ;
    for( int j = 0; j < a.length; j++ ){

      if (thisSum == 0){ thisFrom = j ; }

        thisSum += a[ j ];
        if( thisSum > maxSum ){
            from = thisFrom;
            to = j;
            maxSum = thisSum; 
        }
        else if( thisSum < 0 )
            thisSum = 0;
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(a, from, to+1)));
    System.out.println( maxSum );