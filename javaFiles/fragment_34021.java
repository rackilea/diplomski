public static int firstInSet(String str, String set) {
      int pos = 0;
      for (char c : str.toCharArray()) {
         int i = set.indexOf(c);
         if (i >= 0) {
            return  pos;
         }
         pos++;
      }
      return -1;
   }