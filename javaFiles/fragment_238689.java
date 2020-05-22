String result = String.join(
    "+",
    Arrays.asList(pattern.split("\\+"))
        .stream()
        .map((String s) -> vals.get(s))
        .collect(Collectors.toList())
);