final int fastlen = 256;
   int i=0;
   while (++i < fastlen) {
       char c = p.charAt(i);
       if (p.lastIndexOf(c, fastlen) != i) return true;
         // maybe lastIndexOf(c, i + fastlen)?  We're going to repeat work anyway, so what's a little more?
   }
   // i == fastlen if we haven't returned yet
   for ( ; i < N ; i++ ){
       char c = p.charAt(i);
       if (p.lastIndexOf(c, fastlen) != -1 ||
           p.indexOf(c, i + 1) != -1 )
           return true;
   }