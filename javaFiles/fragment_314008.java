boolean doesExist(File[] files, String searchFileName) {
  boolean exists = false;
  for (File f : files) {
    if (f.getName().equals(searchFileName)) {
      exist = true;
    } else if (f.isDirectory()) {
      exist = doesExist(f.listFiles(), searchFileName);
    }
    if (exist) {
      break; // no need to proceed further
    }
  }
  return exist;
}