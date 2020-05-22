public class MyClass {
    public static void main(String[] args) {
        ClassA a = new ClassA(1, 1);
        ClassB b = new ClassB(a);

        System.out.println("x: " + b.classA.x + ", y: " + b.classA.y);
    }
}