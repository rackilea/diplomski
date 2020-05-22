public static String removeChars(String str, String remove) {
   String newStr = "";
   for (int i = 0; i < str.length(); i++) {
      if (remove.indexOf(str.charAt(i)) == -1) {
       newStr = newStr + str.charAt(i);
      }
   }

   return newStr;
}