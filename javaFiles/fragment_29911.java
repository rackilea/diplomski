try (Stream<String> stream = Files.lines(Paths.get(path))) {
    stream
        .skip(1) // skip headers
        .map(line -> line.split(","))
        .map(data -> IntStream.range(0, data.length)
            .boxed()
            .collect(Collectors.toMap(i -> headers[i], i -> data[i])))
        .forEach(System.out::println);
}