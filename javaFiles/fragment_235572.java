public class Bar implements ExceptionHandler{//the class who handles the exception
  @Override
  public void handleException(Throwable t) {
    System.out.println("Ta Ta");
    System.out.println(t.getMessage());
  }
}