class A {
    protected int size = 1;
}
class B extends A {
    protected int size = 2;
}
class C extends B {
    protected int size = 3;

    void printSize() {
        System.out.println(((A)this).size);  // 1
        System.out.println(super.size);      // 2
        System.out.println(this.size);       // 3
    }
}