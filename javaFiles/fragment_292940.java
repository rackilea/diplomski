Map<String,Long> result;
try(Stream<String> lines = Files.lines(path)) {
    result = lines
        .flatMap(Pattern.compile("\\s+")::splitAsStream)
        .flatMapToInt(String::chars)
        .filter(c -> !Character.isAlphabetic(c) || "aeiou".indexOf(c) >= 0)
        .mapToObj(c -> "aeiou".indexOf(c)>=0? "totalVowelCount": "totalSpecialCharacter")
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}