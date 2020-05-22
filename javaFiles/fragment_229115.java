static class HDouble {
    double value;
}

public static void main(String[] args) {
    primitive();
    wrapper();
}

public static void primitive() {
    long start = System.nanoTime();
    for (double d = 0; d < 1000000000; d++) {
    }
    long end = System.nanoTime();
    System.out.printf("Primitive: %.3f s\n", (end - start) / 1e9);
}

public static void wrapper() {
    HDouble d = new HDouble();
    long start = System.nanoTime();
    for (d.value = 0; d.value < 1000000000; d.value++) {
    }
    long end = System.nanoTime();
    System.out.printf("Wrapper:   %.3f s\n", (end - start) / 1e9);
}