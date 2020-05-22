public static boolean containsNumber(String str) {
      boolean found = false;
      for (char c : str.toCharArray()) {
         if (Character.isDigit(c)) {
            found = true;
            break;
         }
      }
      return found;
   }