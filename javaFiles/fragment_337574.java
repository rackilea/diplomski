private static void write0a(StringBuilder sb, Boolean append) throws Exception {
  File file = File.createTempFile("foo", ".txt");

  try(Writer writer = Channels.newWriter(new FileOutputStream(
      file.getAbsoluteFile(), append).getChannel(), "UTF-8")) {
    writer.append(sb);
  }
}