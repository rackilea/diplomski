// produce range 0..99 (10 elements at a time)
    return IntStream.rangeClosed(0, 9)
        .flatMap(i -> IntStream.rangeClosed(i * 10, i * 10 + 9))
        .peek(System.out::println)
        .filter(i -> i == 55)
        .findFirst()
        .getAsInt();