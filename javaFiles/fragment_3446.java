public static long powerN(
   int number, 
   int power
) {
   if(power == 0) return 1;
   int result = number;

   while(power > 1) {
      result*=number;
      power--;
   }

   return (long)result;
}