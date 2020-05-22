public static String[] sortStringBubble( String  x [ ] )
   String[] copy = new String[x.length];
   System.arraycopy(x, 0, copy, 0, x.length);

   // do everything on the copy

   return copy;
}