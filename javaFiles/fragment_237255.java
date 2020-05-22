@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserFriendlyException.class)
    public ModelAndView handleUserFriendlyException(UserFriendlyException ex) {
        //handle here your custom error page
    }
}