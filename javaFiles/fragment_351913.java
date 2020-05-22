public static void main(String[ ] args)
 {
         String[ ] names = {"apple","banana","jelly","jam","Thandi","Thomas","hi","Hi","someone","some-one"}; //This line creates an array and adds your values in to the created array
         sortStringExchange (names); //the method below is called
         for ( int k = 0;  k < names.length;  k++ )
            System.out.println( names [ k ] );      // prints all the values in the array in ascending order
  }

  public static void sortStringExchange( String  x [ ] )
  {
        int i, j;
        String temp;

        for ( i = 0;  i < x.length - 1;  i++ )
        {
            for ( j = i + 1;  j < x.length;  j++ )
            { 
                     if ( x [ i ].compareToIgnoreCase( x [ j ] ) > 0 )
                      {                                             // ascending sort
                                  temp = x [ i ];
                                  x [ i ] = x [ j ];    // swapping
                                  x [ j ] = temp;

                       }
               }
         }
  }