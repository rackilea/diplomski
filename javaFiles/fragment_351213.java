public class UploadAction extends ActionSupport {
  private String name;
  private File file;

  //getter and setter

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String upload() throws Exception{
      Files.move(file.toPath(),Paths.get("C:\\tmp\\"+name), StandardCopyOption.REPLACE_EXISTING);
      return SUCCESS;
  }
}