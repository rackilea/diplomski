public String[] split(String regex, int limit) {
   /* fastpath if the regex is a
      (1)one-char String and this character is not one of the
         RegEx's meta characters ".$|()[{^?*+\\", or
      (2)two-char String and the first char is the backslash and
         the second is not the ascii digit or ascii letter.
   */
   char ch = 0;
   if (((regex.count == 1 &&
       // a bunch of other checks and lots of low-level code
       return list.subList(0, resultSize).toArray(result);
   }
   return Pattern.compile(regex).split(this, limit);
}