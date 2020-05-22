// If you use this code seriously somewhere, I will find you
IntStream.generate(() -> 0)
    .peek(i -> {
        // Any custom logic
        System.out.println(i);
    })
    .noneMatch(i -> isTrue());