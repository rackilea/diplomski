public static Map<String, Integer> countJava8(String input) {
    return Pattern.compile("\\W+")
                  .splitAsStream(input)
                  .collect(Collectors.groupingBy(String::toLowerCase,
                                                 Collectors.summingInt(s -> 1)));
}