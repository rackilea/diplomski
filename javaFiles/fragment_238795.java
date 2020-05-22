private static class A {
    B out = new B();
}

private static class B {
    void println(String foo) {
        System.out.println("ha");
    }
}

public static void main(String[] args) {
    {
        A System = new A();
        System.out.println("a");
    }
    System.out.println("b");
}