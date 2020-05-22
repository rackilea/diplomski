public class ClassA {
    int a;
    ClassB b;
    public ClassA() {
        b = new ClassB();
        b.setClassA(this);
    }
}

public class ClassB {
    int someInt;
    ClassA classA;
    public ClassB() {
    }
    void setClassA(ClassA classA) {
        this.classA = classA;
    }
    void someFunction() {
        System.out.println(classA.a);
    }
}