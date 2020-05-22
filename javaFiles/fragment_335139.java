private static List<String> readBatch(Reader reader, int batchSize) throws IOException {
   List<String> result = new ArrayList<>();
   for (int i = 0; i < batchSize; i++) {
     String line = reader.readLine();
     if (line != null) {
      result.add(line);
     } else {
      return result;
     }
  }
  return result;
}