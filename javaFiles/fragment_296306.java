public static int LINES_BATCH = 10000;

private static void scriptNoComment(String fileName) {

  Path filePath = Paths.get(fileName);
  try (Stream<String> stream = Files.lines(filePath); BufferedWriter fileOut = getFileOutWriter(fileName)) {

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

      if (linesWithNoComments.size() >= LINES_BATCH) {
        writeCurrentBatchToFile(fileOut, linesWithNoComments);
      }

    });

  } catch (IOException e) {
    e.printStackTrace(System.err);
  }
}

private static BufferedWriter getFileOutWriter(String fileName) {
  BufferedWriter fileOut;
  try {
    fileOut = new BufferedWriter(new FileWriter(fileName + "_noComments", false));
    return fileOut;
  } catch (IOException e) {
    throw new RuntimeException("Error while creating out writer", e);
  }
}

private static void writeCurrentBatchToFile(BufferedWriter fileOut, List<String> linesWithNoComments) {
  try {

    for (String line : linesWithNoComments) {
      fileOut.write(line + " ");
    }

    linesWithNoComments.clear();
  } catch(IOException e) {
    throw new RuntimeException("Unable to write lines to file", e);
  }
}