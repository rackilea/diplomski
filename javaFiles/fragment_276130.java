public static String toBin(int dec) {
      StringBuilder sb = new StringBuilder();

      while (dec > 0) {
         // by inserting at 0, the bits end up in
         // correct order.  Adding '0' to the low order
         // bit of dec converts to a character.
         sb.insert(0, (char) ((dec & 1) + '0'));

         // shift right for next bit to convert.
         dec >>= 1;
      }
      return sb.toString();
   }