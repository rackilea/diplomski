int max = 10;
int[] divisors = {2, 3, 5};

// no divisor
IntStream.rangeClosed(0, max)
        .filter(n -> IntStream.of(divisors).allMatch(d -> n % d != 0))
        .forEach(System.out::println);

// any divisor
IntStream.rangeClosed(0, max)
        .filter(n -> IntStream.of(divisors).anyMatch(d -> n % d == 0))
        .forEach(System.out::println);