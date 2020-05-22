public static <T> void handle(T objT) {
    System.out.println("T");
}

private static <T extends B> void handle(T obj) {
    System.out.println("B");
}

public static <T extends B & I> void handle(T objT) { <--- Problem 2
    System.out.println("B+I");
}

private static <T extends I> void handle(T obj) {
    System.out.println("I");
}