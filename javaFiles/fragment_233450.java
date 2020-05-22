public class Resource {
    private Resource() {}

    // some methods, abstract methods, etc...

    public static class File extends Resource {
      private File() {}

      // etc...
    }

    private static final File FILE = new File();

    // other subclasses of Resource
}