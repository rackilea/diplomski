Path base = Paths.get("/some/start/path");

try (Stream<Path> items = Files.list(base)) {
    Path found = items
            .filter(Files::isDirectory)
            .sorted()
            .findFirst()
                .orElse(base);

    System.out.println("New directory is: " + found);
}