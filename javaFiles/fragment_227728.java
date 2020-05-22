public static enum FileType {
  CSV, XML, XLS, TXT, FIXED_LENGTH;

  // Java < 8
  public boolean in(FileType... fileTypes) {
    for(FileType fileType : fileTypes) {
      if(this == fileType) {
        return true;
      }
    }

    return false;
  }

  // Java 8
  public boolean in(FileType... fileTypes) {
    return Arrays.stream(fileTypes).anyMatch(fileType -> fileType == this);
  }
}