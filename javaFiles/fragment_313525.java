// produce range 0..99 (all 100 elements at once)
    return IntStream.rangeClosed(0, 99)
        .peek(System.out::println)
        .filter(i -> i == 55)
        .findFirst()
        .getAsInt();