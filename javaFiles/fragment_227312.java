@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(TheExceptionYouWantToHandle.class)
  public String handleYourException(HttpServletRequest request, Exception ex){

    return "name_of_view_you_want_to_show";
  }
}