public static boolean isJavaIdentifierStart (char c) {
   return (c >= 'a' && c <= 'z') ||
          (c >= 'A' && c <= 'Z') ||
          (c == '_')             || 
          (c == '$');
}