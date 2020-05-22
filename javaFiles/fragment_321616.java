public A() {
    int n = ...;
    if (n <= 0) {
        throw new IllegalArgumentException("n is less than 0");
    }
}