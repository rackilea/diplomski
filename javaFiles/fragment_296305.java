public static String scriptNoComment(String fileName) {

  Path filePath = Paths.get(fileName);
  try (Stream<String> stream = Files.lines(filePath)) {

    List<String> linesWithNoComments = new ArrayList<String>();

    stream.forEach(line -> {

      if (line.startsWith("--")) {
        return;
      }

      String currentLine = line;

      int commentStartIndex = line.indexOf("--");
      if (commentStartIndex != -1) {
        currentLine = line.substring(0, commentStartIndex);
      }

      currentLine = currentLine.toUpperCase();
      currentLine = currentLine.replaceAll("\"", "");
      currentLine = currentLine.replaceAll("\\r\\n|\\r|\\n", " ");
      currentLine = currentLine.replaceAll("\\s+", " ").trim();

      if (currentLine.isEmpty()) {
        return;
      }

      linesWithNoComments.add(currentLine);

    });

    return String.join("\n", linesWithNoComments);

  } catch (IOException e) {
    e.printStackTrace(System.out);
    return "";
  }
}