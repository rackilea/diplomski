class ClassA {
    static int a = 10;
}

class ClassB {
    static void look() {
        System.out.println("B sees " + ClassA.a);
    }
    static void change() {
        ClassA.a = 42;
    }
}

class ClassC {
    static void look() {
        System.out.println("C sees " + ClassA.a);
    }
    static void change() {
        ClassA.a = 67;
    }
}