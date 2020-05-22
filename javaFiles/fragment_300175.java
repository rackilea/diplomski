public static void main(String[] args) throws IOException {
    changeEncoding("in_cn.txt", Charset.forName("GBK"),
        "out_cn.txt", Charset.forName("GB18030"));
  }

  private static void changeEncoding(String inFile,
      Charset inCharset, String outFile, Charset outCharset)
      throws IOException {
    InputStream in = new FileInputStream(inFile);
    Reader reader = new InputStreamReader(in, inCharset);
    OutputStream out = new FileOutputStream(outFile);
    Writer writer = new OutputStreamWriter(out, outCharset);
    copy(reader, writer);
    writer.close();
    reader.close();
    // TODO: try/finally blocks; proper stream handling
  }

  private static void copy(Reader reader, Writer writer)
      throws IOException {
    char[] cbuf = new char[1024];
    while (true) {
      int r = reader.read(cbuf);
      if (r < 0) { break; }
      writer.write(cbuf, 0, r);
    }
  }