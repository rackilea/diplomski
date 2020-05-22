public static void main(String[] args) {
    System.out.println("After: " + X);
}

private static final long X = assign();

private static long assign() {
    // Access the value before first assignment
    System.out.println("Before: " + X);

    return X + 1;
}