public class MyClass {

  private final String filePath;

  @Inject public MyClass(@Named("filePath") String filePath) {
    this.filePath = filePath;
    // ...
  }

  // ...
}