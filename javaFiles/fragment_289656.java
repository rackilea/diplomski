public static int toBin(int Num) {
   String result = "";

   while (Num > 0) {
      int mod = Num % 2;
      result = mod + result;
      Num /= 2;
   }
   return Integer.parseInt(result);
}