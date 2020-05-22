public static double getAvg(double numbers[]){
     return getTotal(numbers)/numbers.length;
}

public static double getTotal(double numbers[]){
   double total = 0;
   for(double i:numbers)
       total +=i;
   return total;
}