private static void initializeBigIntegerArray(BigInteger[] bigIntegers) {
   for (int i=0; i<bigIntegers.length; i++) {
      // So you don't overwrite anything you assign explicitly
      if (bigInteger[i] == null) {
         bigIntegers[i] = BigInteger.ZERO;
      }
   }
}