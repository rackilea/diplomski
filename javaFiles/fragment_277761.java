public (abstract) class Parent{        }

public class A extends Parent {        }

public class B extends Parent {        }

public class C {
    private A a;
    private B b;
    private Parent thirdVariable;
}