String inFileName = "Sample.log";
String outFileName = "Sample_output.log";
try (Stream<String> stream = Files.lines(Paths.get(inFileName))) {
    List<String> timeStamp = stream
        .flatMap(s -> Stream.concat(quoteRegex1.results(s),
                        Stream.concat(quoteRegex2.results(s), quoteRegex3.results(s))))
        .map(r -> r.group(1))
        .collect(Collectors.toList());

    timeStamp.forEach(System.out::println);
    //Files.write(Paths.get(outFileName), dataSet);
}