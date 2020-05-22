String result;

try(Stream<String> lines = Files.lines(Paths.get("2_june.txt")){
    result = lines.map(x -> x + "\\n")
                  .collect(Collectors.joining());
}