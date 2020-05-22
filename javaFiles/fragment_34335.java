final static String hex = "0123456789ABCDEF";

   static int stringToInt(String str, int radix) {
      if (radix < 2 || radix > 16) {
         System.out.println("Base must be between 2 and 16 inclusive");
         return -1;
      }
      int v = 0;
      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);
         int idx = indexOf(hex, c);
         if (idx < 0 || idx > radix) {
            System.out.println("Illegal character in string (" + c + ")");
         }
         v = v * radix + idx;
      }
      return v;
   }

   static String intToBase(int v, int radix) {
      if (radix < 2 || radix > 16) {
         System.out.println("Base must be between 2 and 16 inclusive");
         return null;
      }
      String s = "";
      while (v > 0) {
         int idx = v % radix;
         s = hex.charAt(idx) + s;
         v /= radix;
      }
      return s;
   }

   static int indexOf(String str, char c) {
      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) == c) {
            return i;
         }
      }
      return -1;
   }