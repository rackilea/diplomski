public static void tryWithAuto() throws Exception {
    try (AutoCloseable c=dummy()) {
        bar();
    }
}
private static AutoCloseable dummy() {
    return null;
}
private static void bar() {
}