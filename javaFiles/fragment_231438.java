int foo() {
    int x = someValue();
    if (x > 10) {
       return 1;
    }
    if (x <= 10) {
       return 20;
    }
    // Is this reachable or not?
}