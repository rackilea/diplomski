Arrays.stream(sides)
    .forEach(
    line -> {
         Generator.combination(Arrays.stream(line).boxed().collect(Collectors.toList()))
        .simple(3)
        .stream()
        .forEach(System.out::println);
    }
);