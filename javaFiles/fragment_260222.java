public static void halfTriangleJava8(){
    IntStream.range(1, 5).forEach(i -> {
        IntStream.rangeClosed(1, i).forEach(j -> System.out.print("* "));
        System.out.println(" ");
    });
}