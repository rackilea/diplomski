void foo() {
    int a = 42;
    bar(a);
    System.out.println("foo says: " + a);
}
void bar(int a) {
    a = 67;
    System.out.println("bar says: " + a);
}