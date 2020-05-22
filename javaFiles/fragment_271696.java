A x = new B();
C y = new C(); 
A z = new C();

A. x.a2(); // Method is overriden.
B. z.a2(); // Method is inherited.
C. z.c1(); // Won't compile. Method isn't defined in A.
D. z.a1(); // Method is implemented.
E. y.c1(); // Not polymorphic. Method is defined in declared class C.
F. x.a1(); // Method is implemented.