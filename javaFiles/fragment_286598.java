public void test(int a, int b, int c) {
    boolean good = true;
    if (good = good && a > 5) {
        System.out.println("Very well, a > 5");
    }
    if (good = good && b > 7) {
        System.out.println("Even better, b > 7");
    }
    if (good = good && c > 13) {
        System.out.println("Even better, c > 13");
    }
    // Have as many conditions as you need, and then
    if (!good) {
        System.out.println("I don't like your variables");
    }
}