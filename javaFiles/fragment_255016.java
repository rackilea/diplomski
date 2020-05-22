static Set<String> supportedExtensions=new HashSet<String>();

    static
    {
      //populate supportedExtensions
    }

    while ((lNextLine = reader.readNext()) != null) 
    {
      for(int i = 0;i < lNextLine.length; i++)
      {
        String lFilename = lNextLine[0];
        String[] lext = lFilename.split("\\.");
        return supportedExtensions.contains(lext[lext.length - 1]);
      }
    }