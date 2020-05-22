class MyClass1 {
    private static MyObject obj = new MyObject("MyClass1");
    public static void doSomething() {
        MyClass1.obj.print();
        MyClass2.obj.print();
    }
}

class MyClass2 {
    private static MyObject obj = new MyObject("MyClass2");
    public static void doSomething() {
        MyClass1.obj.print();
        MyClass2.obj.print();
    }
}

class MyObject {
    private final String name;
    MyObject(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Q: Which object called me?");
        System.out.println("A: " + name);
    }
}