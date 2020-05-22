Stream<String> patterns = getMyPatterns(
    Stream.of("a1", "a2").peek(s -> System.out.println("consuming "+s)),
    Stream.of("b1", "b2"),
    Stream.of("c1", "c2"));

System.out.println("start consuming result Stream");
System.out.println(patterns.collect(Collectors.joining(", ")));