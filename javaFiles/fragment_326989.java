public class MyClass implements MyInterface<Object> {

    Object doSomething(Object T) {
        if (T instanceof SomeClass) {
            doSomethingSomeClass((SomeClass)T);
        } else if (T instanceof SomeOtherClass) {
            doSomethingSomeOtherClass((SomeOtherClass)T) {
        } else {
            // handle other objects - return null? throw exception?
        }
    }

    SomeClass doSomethingSomeClass(SomeClass T) {
        //here the implementation
    }

    SomeOtherClass doSomethingSomeOtherClass(SomeOtherClass T) {
        //here the implementation
    }
}