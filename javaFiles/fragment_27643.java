CustomStream<String> stream = new CustomStreamImpl<>(Stream.of("Hello", "World"));
stream
    .filter(s -> s.equals("Hello"))
    .something()
    .map(String::length)
    .something()
    .forEach(System.out::println);