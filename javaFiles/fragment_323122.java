private static String concatenateFilePaths(
    String directory, String extension) {
  StringBuilder sb = new StringBuilder();
  File f = new File(directory);
  if (f != null && f.isDirectory()) {
    File[] files = f.listFiles();
    for (File file : files) {
      if (file != null
          && file.getName().endsWith(extension)) {
        if (sb.length() > 0) {
          sb.append(", ");
        }
        sb.append('"');
        sb.append(file.getPath());
        sb.append('"');
      }
    }
  }
  return sb.toString();
}