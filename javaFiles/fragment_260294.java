class Test {
    public static void main(String[] args) {
        method({1, 2, 3});          // it is not allowed
        method(new int[]{1, 2, 3}); // it is fine
    }

    static void method(int[] ints) { ... }
}