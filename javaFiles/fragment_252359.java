@ControllerAdvice
public class ExceptionHandling {

  @ExceptionHandler(value=Exception.class)
  public String showErrorPage(){
    return "error";
  }
}