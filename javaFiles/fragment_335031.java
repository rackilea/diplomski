try (Stream<String> lines = Files.lines(Paths.get("input.txt"))) {
    String result = lines
            .map(line -> line.replace("Images", "http://google.com/Images"))
            .collect(Collectors.joining("\n"));
    System.out.println(result);
}