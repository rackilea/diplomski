void printInt(int x) {
  String s = String.valueOf(x);
  for(int i = 0; i < s.length(); i++) {
     System.out.write(s.charAt(i));
  }
  System.out.write('\n');
}