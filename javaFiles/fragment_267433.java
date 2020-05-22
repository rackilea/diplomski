public static void main(String[] args) {
    KotlinClass o = new KotlinClass();
    o.getA(); // 1
    // o.setA(1); // not exists
    o.getB(); // 2
    o.setB(1);
    o.c; // 3
    o.getC(); // 3
    // o.c = 1; // compile error
    // o.setC(1); // not exists
    o.d; // 4
    o.getD(); // 4
    o.d; = 4
    o.setD(1);
}