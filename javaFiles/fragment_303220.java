class Parent {
    public static void Foo() {
        int x = Child.YEP;    // Ok
        int y = Child.NOPE;   // Error
    }
}

class Child extends Parent {
    public  static final int YEP  = 42;
    private static final int NOPE = 66;
}