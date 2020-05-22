class A {
    static int x; // class variable
    int y;        // instance variable

    public A(int val) {
        x = val; // All 'A' classes now have x = val;
        y = val; // Only 'this' class has y = val;
    }
}