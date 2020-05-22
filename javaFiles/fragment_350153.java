abstract class ClassA {
    protected abstract Class1 methodName();
}

class ClassB extends ClassA {
    @Override
    protected Class2 methodName() {
        return new Class2();
    }
}