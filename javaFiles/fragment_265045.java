static double cutRod(double price[],int custom_sizes[], int n) 
 { 
   double val[] = new double[n+1]; 
   val[0] = 0; 

   for (int i = 1; i<=n; i++) 
   { 
       double max_val = Integer.MIN_VALUE; 
       for (int j = 0; j < custom_sizes.length; j++) {
           if (i - custom_sizes[j] >= 0)
             max_val = Math.max(max_val,  
                                price[j] + val[i-custom_sizes[j]]); 
       }
       val[i] = max_val; 
   } 
   return val[n];
}