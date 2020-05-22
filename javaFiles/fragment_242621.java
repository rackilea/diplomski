class A {};
class B {
   public A a;
   public B() {
       a = new A();
   }
};
class C {
    public B b;
    public C( B b ) {
        this.b = b;
    }
    public void someMethod() { 
        System.out.println( b.a );
    }
};