void greet(String name) {
    if (name == null) {
        throw new IllegalArgumentException("Cannot greet null");
    }
    System.out.println("Hello, " + name);
}