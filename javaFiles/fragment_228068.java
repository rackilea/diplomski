public class MyException extends Exception {
  public MyException() {
    super("my default message");
  }

  public MyException(String message) {
    super(message);
  }
}