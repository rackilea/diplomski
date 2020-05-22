public static int div1(int x , int y) { 

// i replaced r with x for readibility
   while ( x >= y ) {
       x = x - y ;  
   }
   return x; // this is your variable r
}

public static int div2(int x, int y) {
    int q = 0;
    int r = x;
    while ( r >= y ) {
        r = r - y ;  // r is required here because it is your update statement in while loop
        q = q + 1 ;  
    }
    return q;
}