public String readFirstChars(File f, int number) throws IOException {
  Reader r = new BufferedReader(new InputStreamReader(
          new FileInputStream(f), "US-ASCII"));
  try {
    StringBuilder resultBuilder = new StringBuilder();
    int count = 0;
    int intch;
    while (((intch = r.read()) != -1) && count < number) {
      resultBuilder.append((char) intch);
      count++;
    }
    return resultBuilder.toString();
  } finally {
    r.close();
  }
}