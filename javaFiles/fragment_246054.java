interface A {
    void method();
}

interface B extends A {
    @Override
    default void method() {
        System.out.println("B");
    }
}

interface C extends A { 
    @Override
    default void method() {
        System.out.println("C");
    }
}

interface D extends B, C {

}