Charset utf8 = Charset.forName("UTF-8");
OutputStream out = new FileOutputStream(file);
Closeable stream = out;
try {
  Writer writer = new OutputStreamWriter(out, utf8);
  stream = writer;
  // write to writer here
} finally {
  stream.close();
}