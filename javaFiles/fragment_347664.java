public class ClassA {
    int x;
    int y;
    public ClassA() {}
    public ClassA(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

public class ClassB {
    ClassA classA;
    public ClassB(){}
    public ClassB(ClassA _classA) {
        classA = _classA;
    }
}