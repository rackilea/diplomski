public static int GetTheBiggestNum(int[] num) {
   if (num.length == 0) {
      throw new IllegalArgumentException("Array cannot empty")
   }

   int biggest = num[0]; 
   for (int i = 1; i < num.length; i++) {
      if (num[i] > biggest)
         biggest = num[i];
   }
   return biggest;
}