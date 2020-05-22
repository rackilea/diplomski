Map<String,Long> result;
try(Stream<String> lines = Files.lines(path)) {
    result = lines.flatMap(Pattern.compile("\\s+")::splitAsStream)
        .flatMapToInt(w -> IntStream.concat(IntStream.of(-1), w.chars()))
        .mapToObj(c -> c==-1? "totalWordCount": "aeiou".indexOf(c)>=0? "totalVowelCount":
                Character.isAlphabetic(c)? "totalAlphabetic": "totalSpecialCharacter")
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}