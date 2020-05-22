Function<String, String> func = s -> s.replaceAll("a", "");

Optional.ofNullable(string).map(func)
    .filter(s -> s.isEmpty())
    .map(s -> "String" + s)
    .ifPresent(System.out::println);