Charset.availableCharsets().values().stream().filter(Charset::canEncode).collect(
    Collectors.groupingBy(
            charset -> charset.newEncoder().replacement(),
            () -> new TreeMap<>(Comparator.comparing(ByteBuffer::wrap)),
            Collectors.mapping(Charset::name, Collectors.joining(", "))))
    .values().forEach(System.out::println);