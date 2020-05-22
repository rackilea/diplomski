interface A {
    int x = 10;
}

class B implements A {
    static int x = 5;
    void test() {
        System.out.println(x);
    }
}