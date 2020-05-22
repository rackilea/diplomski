public static void copyStream(Reader istream, Writer ostream) throws IOException {
  char buffer[] = new char[2048];
  while (true) {
    int len = istream.read(buffer);
    if (len == -1)
      return;
    ostream.write(buffer, 0, len);
  }
}