public class ClassA {
    final ClassB objectOfB;

    public ClassA(ClassB objectOfB) {
        this.objectOfB = objectOfB;
    }

    public int add(int a, int b) {
        int addition = objectOfB.performCalculation(a,b);
        return addition;
    }
}