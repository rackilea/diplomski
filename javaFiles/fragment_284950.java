add(a,c); // exact match to add(int a, long b)
   add(a,d); // exact match to add(int a, Long b)
   add(b,c); // there is no exact match, so at least one of the passed parameters must
             // be boxed or unboxed. However, by unboxing b to int or boxing 
             // c to Long, each of the three add methods can match, and the 
             // compiler doesn't know which one to prefer
   add(b,d); // exact match to add(Integer a, Long b)