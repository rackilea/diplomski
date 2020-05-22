public double fnc(double x) {
      double a, s, k;
      int i;
      k = -2.;
      s = 0;
      a = ((1 - x) / (1 + x));
      double aa = a * a;
      i = 1;
      while (i < 10) {
         // first time thru, a is power of 1
         s = s + ((k / i) * a); 
         // now a is power of 3, then 5, etc.
         a = a * aa; 
         i = i + 2;
      }
      return s;
   }