public interface Reader {

  default String read(String name) {
    return "reading from " + name;
  }

}

public interface FileInputBase {

  default String getFormat(String path) {
    return "Format of " + path;
  }

}


public class FileStreamInput implements Reader, FileInputBase {

  private String path;

  private String name;


  public FileStreamInput(String path, String name) {
    super();
    this.path = path;
    this.name = name;
  }

  public String read(String name) {
    return "FileStreamInput: reading from " + name;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFormat() {
    return getFormat(path);
  }

  public static void main(String[] args) {
    FileStreamInput input = new FileStreamInput("Alice", "/home/alice");
    System.out.println("format: " + input.getFormat());
  }

}