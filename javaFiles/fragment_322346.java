static void f(int i) {
    System.out.println("(int)");
}
static void f(double d) {
    System.out.println("(double)");
}

//...
f(1);   // prints "(int)"
f(1D);  // prints "(double)"