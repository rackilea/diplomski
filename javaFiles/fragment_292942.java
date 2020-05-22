Map<String,Long> result;
try(Scanner scanner = new Scanner(path)) {
    result = scanner.findAll("\\S+")
        .flatMapToInt(w -> IntStream.concat(IntStream.of(-1), w.group().chars()))
        .mapToObj(c -> c==-1? "totalWordCount": "aeiou".indexOf(c)>=0? "totalVowelCount":
                Character.isAlphabetic(c)? "totalAlphabetic": "totalSpecialCharacter")
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}