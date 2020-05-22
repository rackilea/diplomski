public int countFiles(File directory, String... exts) {
  int count = 0;
  File[] files = directory.listFiles();
  if (files != null) {
    for (File file : files) {
      if (file.isDirectory()) {
        count += countFiles(file, exts);
      } else {
        String textFile = file.toString();
        for (String ext : exts) {
          if (textFile.endsWith(ext)) {
            count++;
          }
        }
      }
    }
  }
  return count;
}