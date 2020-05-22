public class FindClass {

  public boolean findClass(String className) {
    try {
        FindClass.class.getClassLoader().loadClass(className);
        return true;
    } catch (ClassNotFoundException e) {
        return false;
    }
  }