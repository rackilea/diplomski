public static void maxp () {
    int maxPalin = -1;
    for (int i = 100; i < 1000; i++) {
        for (int j = 100; j < 1000; j++) {
            int prod = i * j;
            if (reverseNumber(prod) == prod && prod > maxPalin) {
                maxPalin = prod;
            }
        }
    }
    System.out.println(maxPalin);
}