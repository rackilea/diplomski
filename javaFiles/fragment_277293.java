public static double powerFaster(double x, int n) {
     if (n == 0) {
        return 1;
     } 
     else if ((n % 2) == 0) {
       double pow = powerFaster(x, n/2);
       return pow * pow;
     } else {
       return x * powerFaster(x, (n - 1));
     }
 }