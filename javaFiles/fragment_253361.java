interface A {
    void m1();
    void common();
}

interface B {
    void m2();
    void common();
}

abstract class ABClass implements A, B {

    public void common() {
    System.out.println("Default");
}

Class X extends ABClass {
}