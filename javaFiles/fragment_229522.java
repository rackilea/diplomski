public static int countLines(String filename) throws IOException {
    LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
    while (reader.readLine() != null) {}
    reader.close();
    return reader.getLineNumber();
  }