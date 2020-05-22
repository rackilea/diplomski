Optional<String> first=Optional.of("abc");
Optional<String> second=first.map(s -> {
    System.out.println("Running map");
    return s + "def";
});
System.out.println("starting queries");
System.out.println("first: "+(first.isPresent()? "has value": "is empty"));
System.out.println("second: "+(second.isPresent()? "has value": "is empty"));
second.map("second's value: "::concat).ifPresent(System.out::println);