private static void write(StringBuilder sb, Boolean append) throws Exception {
  File file = File.createTempFile("foo", ".txt");

  try(FileWriter writer = new FileWriter(file.getAbsoluteFile(), append)) {
      writer.append(sb);
  }
}