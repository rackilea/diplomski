FileWriter writer = new FileWriter("local file");
try {
  kit.write(writer, doc, 0, doc.getLength());
} finally {
  writer.close();
}