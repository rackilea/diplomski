public static void handle(Object objT) {
    System.out.println("T");
}

private static void handle(B obj) {
    System.out.println("B");
}

public static void handle(B objT) { 
    System.out.println("B+I");
}

private static void handle(I obj) {
    System.out.println("I");
}