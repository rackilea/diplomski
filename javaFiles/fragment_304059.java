public class Test {
  public static void main(String[] args) {
    try {
      try {
        throw new Exception("First exception");
      } finally {
        System.out.println("Normal completion finally block");
      }
    } catch (Exception e) {
      System.out.println("In first outer catch, catching " + e);
    }
    try {
      try {
        throw new Exception("Second exception");
      } finally {
        System.out.println("finally block with exception");
        throw new Exception("Third exception");
      }
    } catch (Exception e) {
      System.out.println("In second outer catch, catching " + e);
    }
  }
}