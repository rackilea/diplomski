/**
   * Takes the file and returns it in a string
   *
   * @param location
   * @return
   * @throws IOException
   */
  public static String fileToString(String location) throws IOException {
    FileReader fr = new FileReader(new File(location));
    return readerToString(fr);
  }

  /**
   * Takes the given resource (based on the given class) and returns that as a string.
   *
   * @param location
   * @param c
   * @return
   */
  public static String resourceToString(String location, Class c) throws IOException {
    InputStream is = c.getResourceAsStream(location);
    InputStreamReader r = new InputStreamReader(is);
    return readerToString(r);
  }

  /**
   * Returns all the lines in the scanner's stream as a String
   *
   * @param r 
   * @return
   * @throws IOException  
   */
  public static String readerToString(InputStreamReader r) throws IOException {
    StringWriter sw = new StringWriter();
    char[] buf = new char[1024];
    int len;
    while ((len = r.read(buf)) > 0) {
      sw.write(buf, 0, len);
    }
    r.close();
    sw.close();
    return sw.toString();
  }