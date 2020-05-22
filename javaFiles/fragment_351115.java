public static void main(String[] args) {
    try {
        System.out.println("Starting");
        bar();
        System.out.println("passed bar");
    } catch (Exception e) {
        System.out.println("foo exception");
    }
}

private static void bar() throws Exception {
    throw new Exception();
}