String words = "Peter Piper picked a peck of pickled peppers. " +
        "A peck of pickled peppers Peter Piper picked. " +
        "If Peter Piper picked a peck of pickled peppers, " +
        "Where's the peck of pickled peppers Peter Piper picked?";
Map<String, Integer> lookup = new LinkedHashMap<>();
String code = Stream.of(words.split("([.,?] *| +)"))
        .map(w -> lookup.computeIfAbsent(w, k -> lookup.size() + 1))
        .map(c -> Integer.toString(c, 36))
        .collect(Collectors.joining(""));
System.out.println(code);
lookup.forEach((w, c) -> System.out.println(Integer.toString(c, 36) + "=" + w));