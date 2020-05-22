public class Main {
  public static void main(String[] args) throws Exception {
    try (AutoCloseable c = () -> { throw new Exception("Failure in the close method"); }) {
      throw new Exception("Usual failure");
    }
  }
}