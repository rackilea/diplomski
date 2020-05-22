public class CustomReader extends Reader {
  private Reader reader;
  private File file;

  public CustomReader(File file) {
    this.file = file;
    this.reader = new FileReader(file);
  } 

  [...]
  @Override
  public void close() {
    super.close();
    // Do what you need to do with your file
  }
}