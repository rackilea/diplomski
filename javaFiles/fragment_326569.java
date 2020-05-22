public String[] split(String regex, int limit) {
       /* fastpath if the regex is a
          (1)one-char String and this character is not one of the
             RegEx's meta characters ".$|()[{^?*+\\", or
          (2)two-char String and the first char is the backslash and
             the second is not the ascii digit or ascii letter.
       */