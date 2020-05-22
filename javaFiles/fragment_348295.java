public interface AwesomeClass {
    public void method();
}

public class Class1 implements AwesomeClass {
    public void method() {
        // do class1 thing
    }
}

public class Class2 implements AwesomeClass {
    public void method() {
        // do class2 thing
    }
}

// ...

AwesomeClass value;
switch (someInt) {
    case 1: value = new Class1(); break;
    case 2: value = new Class2(); break;
}