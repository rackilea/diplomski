int v = 42;
int x = 0;
x = v;        // OKAY!
x++ = v;      // illegal!
(x + 0) = v;  // illegal!
(x * 1) = v;  // illegal!
42 = v;       // illegal!
   // Error message: "The left-hand side of an assignment must be a variable"