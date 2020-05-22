List<Integer> result =
    IntStream.rangeClosed(1, 10)
             .filter(i -> 10 % i == 0)
             .flatMap(i -> i == 5 ? IntStream.of(i) : IntStream.of(i, 10 / i))
             .boxed()
             .collect(toList());