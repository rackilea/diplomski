public static int countUsedBits(long z) {
      if (z == 0) {
         return 0;
      }
      return countUsedBits(z >>> 1) + 1;
   }