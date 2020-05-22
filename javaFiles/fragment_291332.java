List<String> values = Arrays.asList("abc", "ab", "bc", "bcd", "a");
// I group by length and put it into a TreeMap then get the max value
values.stream().collect(groupingBy(String::length, TreeMap::new, toList()))
    .lastEntry()
    .getValue()
    .forEach(System.out::println);