public static void main(String[] args) {
  File log = new File("C:\\Log.txt");
  if (!log.exists()) {
    try {
      /*
       * mkdirs() is not really needed when using the C root,
       * but I like to do this because the path might be changed.
       */
      if (!log.getParentFile().exists()) {
        log.getParentFile().mkdirs();
      }
      log.createNewFile();
    } catch (IOException ex) {
      Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  Search search = new Search();
}