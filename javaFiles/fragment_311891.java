abstract class Superclass {
    abstract void callExampleMethod(AnotherClass anotherClass);
}

class Subclass1 extends Superclass {
    void callExampleMethod(AnotherClass anotherClass) {
        anotherClass.exampleMethod(this);
    }
}
... same for other subclasses ...