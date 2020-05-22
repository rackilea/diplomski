public class ClassA {
    int a;
    ClassB b = new ClassB(this);
}

public class ClassB {
    int someInt;
    ClassA classA;
    public ClassB(ClassA classA) {
        this.classA = classA;
    }
    void someFunction() {
        System.out.println(classA.a);
    }
}