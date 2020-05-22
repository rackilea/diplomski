public int parseInt(String s) { 
    int n   = 0;
    int pow = 1;
    for (int i=s.length() - 1 ; i>=0 ; i--) {
       String si = String.valueOf(s.charAt(i);

       if (si.matches("[0-9]")) {
           n   += pow*(s.charAt(i) - '0');
           pow *= 10;
       } else if (si.matches("+|-") && i == 0) 
           n   *= s.charAt(i) == '+' ? 1 : -1;
         else 
           throw new NumberFormatException();        
    }
    return n;
}