public class A {

    public int someAMethod() {
        B objB = new B();
        return objB.someBMethod();
    }
}

public class B {

    public int someBMethod() {
        C objC = new C();
        return objC.getA();
    }
}