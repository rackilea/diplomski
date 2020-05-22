public static char[][] convertStringListToChars( List<String> stringList ) {
   char[][] chars = new char[ stringList.size() ][];
   for ( int i = 0; i < stringList.size(); i++ ) {
      chars[i] = stringList.get( i ).toCharArray();
   }
   return chars;
}