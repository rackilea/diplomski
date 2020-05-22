class Class1 {}
class Class2 extends Class1 {}

abstract class ClassA {
    protected abstract <T extends Class1> T methodName();
}

class ClassB extends ClassA {
    @Override
    protected Class2 methodName() {
        return new Class2();
    }
}