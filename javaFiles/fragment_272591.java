for ( c = 0 ; c < m ; c++ )   { 
    for ( d = 0 ; d < n ; d++ ) {
        sum[c][d] = first[c][d] + second[c][d];    


        System.out.println("The sum of the two matrices is: "); 
        for ( c = 0 ; c < m ; c++ )
        {
           for ( d = 0 ; d < n ; d++ )
              System.out.print(sum[c][d]+"\t");

           System.out.println();

        }
    }
}