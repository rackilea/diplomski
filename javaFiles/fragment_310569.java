public LargeMap(int value1, ThyPoint p1, ThyPoint p2, ThyPoint p3)  
    {  
       if ( value1 == 0 )  
         System.out.println( p1.toString() + p2.toString() + p3.toString());  
       else 
         System.out.println( p2.toString() + p3.toString() + p1.toString());  
    }