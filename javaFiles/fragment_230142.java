class DataIO {
  public void writeArticleToFile(Article article, String filename, boolean overwrite) throws IOException {
    synchronized(filename.intern()) {
       File file = new File(filename);
       writeArticleToFile(article, file, overwrite);
    }
  }