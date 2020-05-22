public static void SelectionSort ( int [ ] num, int howmany )

    {

        int i, j, first, temp;  
      int compCount = 0;
      int swapCount = 0;


     for ( i = num.length - 1; i > 0; i-- )  
     {
/* you should not be reinitializing swap count and compCount inside the for loop. What this does is make it 0 after each iteration which is not what you want*/
          first = 0;   //initialize to subscript of first element
          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
          {
               compCount++;
               if( num[ j ] < num[ first ] )         
                 first = j;
          }
          temp = num[ first ];   //swap smallest found with element in position i.
          num[ first ] = num[ i ];
          num[ i ] = temp; 
          swapCount++; 

      }    

          System.out.println("selection sort " + compCount + swapCount );