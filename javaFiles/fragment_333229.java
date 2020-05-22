public static int getBinomial(int n, double p) {
   double log_q = Math.log(1.0 - p);
   int x = 0;
   double sum = 0;
   for(;;) {
      sum += Math.log(Math.random()) / (n - x);
      if(sum < log_q) {
         return x;
      }
      x++;
   }
}