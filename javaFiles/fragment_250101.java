public class Main {
  public static void main(String[] args) throws Exception {
    try (AutoCloseable c = () -> System.out.println("close() called")) {
      throw new Exception("Usual failure");
    }
  }
}