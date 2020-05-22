public class SuperClass {
    public void someMethod () {
        System.out.println ("Superclass!");
    }
}

public class DerivedClass extends SuperClass {
    @Override
    public void someMethod () {
        System.out.println ("Derived class!");
    }
}