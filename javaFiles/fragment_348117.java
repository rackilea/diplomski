class A {
    public void foo() {
        System.out.println("super");
    }
}

class B extends A {
    public void foo() {
        super.foo();  // call the overridden method
        System.out.println("sub");
    }
}