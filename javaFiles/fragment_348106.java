if (arg.length > 0)
  {
    // open our file and read everything into a string buffer
    BufferedReader bRead = null;
    try {
      bRead = new BufferedReader(new FileReader(arg[0]));
    } catch(FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(0);
    }
    setupScanner(bRead);
  }