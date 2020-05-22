public class B {

}

public class D extends B {

}

public abstract class Base {

    public abstract B foo();
}

public class Derived extends Base {

    @Override
    public D foo() {
        // TODO Auto-generated method stub
        return new D();
    }

}