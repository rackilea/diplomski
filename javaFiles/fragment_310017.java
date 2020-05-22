final Map<String, String> entries = new HashMap<>();
final Path dict = Paths.get("dictionaryTXT.txt");

String[] array;

for (final String line: Files.readAllLines(dict, StandardCharsets.UTF_8)) {
    array = lines.split("\\s*:\\s*");
    entrues.put(array[0], array[1]);
}