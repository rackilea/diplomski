public static char[] convertStringListToChars( List<String> stringList ) {
   StringBuilder sb = new StringBuilder();
   for ( String x : stringList ) {
      sb.append( x );
   }
   return sb.toCharArray();
}