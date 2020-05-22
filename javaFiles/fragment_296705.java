public static void main(String[] args) {
    long current = System.currentTimeMillis();
    for (int i = 1; i < 1000; i++) {
        System.out.println(fib(i));
    }
    long end = System.currentTimeMillis();
    System.out.printf("Ran in: %d milliseconds", end - current);
}