class Parent {
    void test() {
        subTest();
    }

    void subTest() {
        System.out.println("subTest parent");
    }
}

class Child extends Parent {
    void subTest() {
        System.out.println("subTest Child");
    }
    public static void main(String... args) {
        new Child().test(); // prints "subTest Child"
    }
}