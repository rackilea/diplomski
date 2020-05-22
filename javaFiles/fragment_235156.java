public static String getAllResults() throws IOException {

    Path path = Paths.get("gameResults.txt");
    return Files.lines(path).collect(Collectors.joining("\n"));

}