public static void copyBigArrayAndFilter() {
    long time = System.currentTimeMillis();
    int[] original = IntStream.range(0, 10_000).toArray();
    int[] destination = Arrays.stream(original).filter(i -> i > 1_000 && i < 9_000).toArray();
    System.out.println("Original size: " + original.length);
    System.out.println("Destination size: " + destination.length);
    System.out.println("Duration: " + (System.currentTimeMillis() - time) + " ms." );
}

public static void copyBigArrayAndAdd() {
    long time = System.currentTimeMillis();
    int[] original = IntStream.range(0, 10_000).toArray();
    int[] destination = Arrays.stream(original).flatMap(i -> Arrays.stream(original).map(j -> i + j)).toArray();
    System.out.println("Original size: " + original.length);
    System.out.println("Destination size: " + destination.length);
    System.out.println("Duration: " + (System.currentTimeMillis() - time) + " ms." );
}