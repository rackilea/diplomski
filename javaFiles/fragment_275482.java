public static String hexToBin(byte[] array) {
   StringBuilder binStr = new StringBuilder();
   for (int i = 0; i < array.length; i++) {
      binStr.append(Integer.toBinaryString(array[i]));
   }

   return binStr.toString();
}