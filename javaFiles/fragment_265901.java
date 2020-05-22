public class A {

    BaseClass o;

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

public class B extends BaseClass {
    public void someMethod(){
        //do something
    }
}

public class C extends BaseClass {
    public void someMethod() {
        //do something
    }
}

public abstract class BaseClass {
    public abstract void someMethod();
}