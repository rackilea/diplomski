static double calculateArgument(double val) {
    return val + 10; // or some really complex logic
}

Foo(double a) {
    this(a, calculateArgument(a));
}

Foo(double a, double b) {
    mA = a;
    mB = b;
}