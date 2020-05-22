Number n = null;
Integer i = null;

n = i ;         // Allowed without casting, Number is superclass of Integer
i = n;          // Compiler error, Integer is sub-class of Number
i= (Integer)n;  // Allowed due to the type-cast