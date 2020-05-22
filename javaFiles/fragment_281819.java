public static void method(A a, B b) {
    a.method(b);
}

public void method(B b){
    doSomethingWithA();
    b.doSomethingWithB();
}