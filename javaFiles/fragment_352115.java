if (new File("/etc/passwd").exists()) {
    Path path = Paths.get("/etc/passwd");
    List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
    for (String line : lines) {
        // loop body, same as yours
    }
}