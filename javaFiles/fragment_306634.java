boolean isP(String s) {
  int l = s.length();
  int l2 = l/2;
  int j = l - 1;
  for(int i=0; i<l2; i++) {
    if(s.charAt(i) != s.charAt(j)) {
        return false;
    }
    j--;
  }
  return true;
}