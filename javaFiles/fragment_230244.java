public static boolean isPrime(double n)
   {
     for(int divisor=3;divisor*divisor<=n;divisor+=2)
     if(n%divisor==0)
     return false;
     return true;
   }