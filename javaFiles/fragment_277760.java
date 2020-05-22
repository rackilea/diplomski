public Interface Parent{        }

public class A implements Parent {        }

public class B implements Parent {        }

public class C {
    private A a;
    private B b;
    private Parent thirdVariable;
}