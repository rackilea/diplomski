1. a = (B)(I)b;    // OK
  The target assignment is of type A.  b is runtime castable to I,
  I is runtime castable to B and B is compile time castable to A.

2. b = (B)(I) a;   // RUNTIME ERROR
  The target assignment is of type B.  a is runtime castable to I, but
  A is not runtime castable to B.

3. a = (I) b;      // COMPILE ERROR
  The target assignment is of type A.  b is runtime castable to I but I cannot 
  be cast at compile time to A.

4. I i = (C) a;    // RUNTIME ERROR
  The target assignment is of type I.  a is not runtime castable to C but C 
  is compile time castable to I.