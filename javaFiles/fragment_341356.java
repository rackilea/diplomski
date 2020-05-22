int nFiles = new File(filename).listFiles( new MyFileFilter() ).length;

...

private static class MyFileFilter extends FileFilter {
  public boolean accept(File pathname) {
     return ! pathname.isDirectory();
  }
}