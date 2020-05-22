public class A {
    //...
}

public class B extends A {
    //...
}

public interface I {
    void test(A a);
}

public class C implements I {
    public void test(A a){

    }
}