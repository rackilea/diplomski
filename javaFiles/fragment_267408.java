public class MyClass {
  private String file1;
  private String file2;
  private final FileBuilder fileBuilder;

  public MyClass() {
    this(new FileBuilder());
  }

  @VisibleForTesting
  MyClass(FileBuilder fileBuilder) {
    this.fileBuilder = fileBuilder;
  }

  public void myMethodSpaceCheck() //...
}