public class A{
    A(int a){
        ...
    }
}

abstract class B extends A{
    B(int a) {// "proxy" constructor"
        super(a);
    }
}

public class C extends B{
    C(int a) {
         super(a);
    }

    void myMethod(int a){
        // super(a); <- note this is invalid code, you can only call this from the constructor
        new C(0); // <-- this is valid
    }
}