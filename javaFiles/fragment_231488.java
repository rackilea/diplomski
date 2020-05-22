Charset.availableCharsets().values().stream().filter(Charset::canEncode).collect(
    Collectors.groupingBy(
            charset -> ByteBuffer.wrap(charset.newEncoder().replacement()),
            TreeMap::new,
            Collectors.mapping(Charset::name, Collectors.joining(", "))))
    .values().forEach(System.out::println);