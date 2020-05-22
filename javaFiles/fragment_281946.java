public static int product(int n1, int n2) 
           { 
              if (n2 > 1) 
              { 
                  n1 += product(n1,n2-1) ; 
              } 
                 return n1; 
           }