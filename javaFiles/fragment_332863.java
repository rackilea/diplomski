public class FileUtils {
  private FileUtils() {} // this prevent class being instantiate.

  // we need to make it static so it can be accessed without
  // creating an instance of the class.
  // of course, you can use singleton. But it's another topic
  public static List<VDienas> loadedfile(Context ctxt) {
    ...
  }
}