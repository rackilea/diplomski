for(int i=0;i<s.length(); i++) // -  N/2
     if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {  // ~ worst case =  (N/2 + N/2) * N/2
     return s.charAt(i); // 1 operation

     Total = N/2 + (N/2 + N/2)*N/2 +1 
    = N^2/2 + N/2  + 1