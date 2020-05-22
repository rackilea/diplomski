public static void changenumber(String fileName) throws IOException {
    Path filePath = Paths.get(fileName);
    List<String> lines = Files.readAllLines(filePath);
    lines.set(0, Integer.toString(Integer.parseInt(lines.get(0)) + 1));
    Files.write(filePath, lines);
}