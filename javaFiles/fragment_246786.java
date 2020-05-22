public int foo() {
    alwaysThrow();
    // This is required.
    return 10;
}

private static void alwaysThrow() {
    throw new RuntimeException();
}