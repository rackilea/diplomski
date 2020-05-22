/**
   * Create an Internet shortcut
   * @param name     name of the shortcut
   * @param where    location of the shortcut
   * @param target   URL 
   * @param icon     URL (ex. http://www.server.com/favicon.ico)
   * @throws IOException
   */
  public static void createInternetShortcut
      (String name, String where, String target, String icon) 
    throws IOException
  {
    FileWriter fw = new FileWriter(where);
    fw.write("[InternetShortcut]\n");
    fw.write("URL=" + target + "\n");
    if (!icon.equals(""))  {
      fw.write("IconFile=" + icon + "\n");  
    }
    fw.flush();
    fw.close();
  }