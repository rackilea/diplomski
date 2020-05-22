void test1() {
    int x = 0;
    long b = System.currentTimeMillis();
    for (int i = 0; i < 100_001; i++) {
        int t = 0;
        while (i != t++) {
            x++;
        }
    }
    long b1 = System.currentTimeMillis();
    System.out.println("T(test1) = " + (b1 - b));
    System.out.println("x(test1) = " + x);
}

void test2() {
    int x=0;
    long b = System.currentTimeMillis();
    for (int i = 0; i < 100001; i++) {
        int t = 0;
        while (t++ != i) {
            x++;
        }
    }
    long b1 = System.currentTimeMillis();
    System.out.println("T(test2) = " + (b1 - b));
    System.out.println("x(test2) = " + x);
}