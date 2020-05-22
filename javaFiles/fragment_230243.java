public static boolean isPerfectSquare (int n)
     {
          for(int divisor=2;divisor*divisor<=n;divisor+=2)
         if(divisor * divisor < n) continue;
          else if (divisor * divisor == n ) return true;
          return false;

     }