class A {};
class B {
   public static final A a = new A();
};
class C {
    public void someMethod() { 
        System.out.println( B.a );
    }
};