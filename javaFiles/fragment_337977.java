public static String g(StringBuilder s){
  return new StringBuilder(
   s.reverse().toString()
     .replaceAll("(?s)(.)(?=.*\\1)", ""))
     .reverse().toString();
}