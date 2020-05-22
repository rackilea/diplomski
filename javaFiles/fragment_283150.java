Pattern[] p = Stream.of(reTimeStamp, reHostName, reServiceTime)
        .map(Pattern::compile)
        .toArray(Pattern[]::new);
try (Stream<String> stream = Files.lines(Paths.get(inFileName))) {
    List<String> timeStamp = stream
        .flatMap(s -> MultiPatternSpliterator.matches(s, p))
        .map(r -> r.group(1))
        .collect(Collectors.toList());

    timeStamp.forEach(System.out::println);
    //Files.write(Paths.get(outFileName), dataSet);
}