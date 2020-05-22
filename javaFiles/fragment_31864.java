// #1
  public GraphModel(File file) throws IOException {...}

  // #2
  public GraphModel(String file) throws IOException {...}

  // #3
  public GraphModel(File file) throws IOException {...}
  public GraphModel(String file) throws IOException {
      this(new File(file));
  }