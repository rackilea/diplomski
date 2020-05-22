String weird_transformation(String s) {
  r = "";
  int i = 0;
  int j = s.length() - 1;
  while (i < j) {
    r += s.charAt(i++);
    if (i <= j) {
       r+= s.charAt(j--);
    }
  }
  return r;
}