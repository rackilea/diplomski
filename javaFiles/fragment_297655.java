Stream<String> stream=Stream.of("abc").map(s -> {
    System.out.println("Running map");
    return s + "def";
});
System.out.println("starting query");
Optional<String> result = stream.findAny();
System.out.println("result "+(result.isPresent()? "has value": "is empty"));
result.map("result value: "::concat).ifPresent(System.out::println);