import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Field;

public class TestMe {
  public static void main(String[] args) throws Exception {
    System.out.println("in main");
    testGetObject();
    System.out.println("Second gc() call (in main)");
    System.gc();
    Thread.sleep(1000);
    System.out.println("End of main");
  }

  public static void testGetObject() throws Exception {
    System.out.println("Creating ClassLoader");
    ClassLoader cl = new URLClassLoader(new URL[] {new File("./x").toURI().toURL()});
    System.out.println("Loading Class");
    Class<?> clazz = cl.loadClass("GCTester");

    System.out.println("Getting static field");
    Field field = clazz.getField("INSTANCE");

    System.out.println("Reading static value");
    Object object = field.get(null);
    System.out.println("Got value: " + object);

    System.out.println("First gc() call");
    System.gc();
    Thread.sleep(1000);
  }
}