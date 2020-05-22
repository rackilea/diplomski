class A {}
class B extends A {}
class C extends A {}

//...
B[] bs = new B[2];
A[] as = bs;
as[0] = new C(); //runtime error
B b = bs[0];