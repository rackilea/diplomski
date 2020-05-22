public class MyClassLoader extends ClassLoader {
  public MyClassLoader(URLClassLoader parent, byte[] decryptedBytes) {
    super(parent);
    this.decryptedBytes = decryptedBytes;
  }

  protected byte[] decryptedBytes;

  public Class findClass(String name) {
    byte[] b = loadClassData(name);
    if (b != null) {
      return defineClass(name, b, 0, b.length);
    } else {
      // delegate to parent URL classloader
      getParent().findClass(name);
    }
  }

  private byte[] loadClassData(String name) {
    // load the class data from the connection
    // use JarInputStream, find class, load bytes ...
    . . .
  }
}