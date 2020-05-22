public class A {

    AnInterface o;

    public void setB() {
        o = new B();
    }

    public void getC() {
        o = new C();
    }

    public void use() {
        o.someMethod();
    }

}

public class B implements AnInterface {
    public void someMethod() {
        //do something
    }
}

public class C implements AnInterface {
    public void someMethod() {
        //do something
    }
}

public interface AnInterface {
    public void someMethod();
}