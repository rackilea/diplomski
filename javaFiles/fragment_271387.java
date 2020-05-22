public String swapPairs(String s) {
     if (s.length() < 2)
          return s;
     else
          return swap(s.charAt(0), s.charAt(1)) + swapPairs(s.substring(2));
}