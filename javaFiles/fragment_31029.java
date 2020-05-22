boolean containsThe(Reader reader) throws IOException {
    int c1;
    while ((c1 = reader.read()) != -1) {
      if (c1 != 't') continue;

      int c2 = reader.read();
      if (c2 == -1) return false;
      if (c2 != 'h') continue;

      int c3 = reader.read();
      if (c3 == -1) return false;
      if (c3 == 'e') return true;
    }
    return false;
  }