public static void main(String[] args) {
    System.out.println("After: " + x);
}

private static final int x = assign();

private static int assign() {
    // Access the value before first assignment
    System.out.println("Before: " + x);

    return x + 1;
}