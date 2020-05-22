public static void main(String[] args) throws Exception {
    Set<String> uniqueLines = new HashSet<>();
    Files.lines(Paths.get("", "utf-8"))
            .filter(line -> !uniqueLines.add(line))
            .forEach(System.out::println);
}