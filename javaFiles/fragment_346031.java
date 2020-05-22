public class Program {
  private String id;
  private String title;
  private String description;

  public Program(String id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("Program[id=%s, title=%s, description=%s]", this.id, this.title, this.description);
  }
}