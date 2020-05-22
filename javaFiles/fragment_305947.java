class A {
   public A() {
      this(1); // calls constructor A(int)
      A(1); // calls method A(int)
   }
   public A(int i) {} // constructor A(int)
   public void A(int i) {} // method A(int)

   public A A(A a) { return a; } // method A(A) which returns A
}