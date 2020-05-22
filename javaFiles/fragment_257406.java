class CustomDirectoryFilter implements FileFilter {

private String allowedFileName = "testFolder";

  @Override
  public boolean accept(File pathname) {

    if (pathname.isDirectory()) {
      File[] subFiles = pathName.listFiles();
      for (File file : subFiles){
        if (file.getName().equals(allowedFileName)){
           return true;
        }
      }
    }
    return false; 
  }
}